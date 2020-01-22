package pers.kindem.zed.runtime.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import pers.kindem.zed.runtime.loader.proxy.PluginApplication;
import pers.kindem.zed.runtime.loader.proxy.PluginClassLoader;
import pers.kindem.zed.runtime.loader.proxy.PluginResources;
import pers.kindem.zed.runtime.utils.LogUtil;

public class PluginLoader {
    private static final String TAG = PluginLoader.class.getSimpleName();

    private static Map<String, PluginClassLoader> pluginClassLoaderMap = new HashMap<>();
    private static Map<String, PluginResources> pluginResourcesMap = new HashMap<>();
    private static Map<String, PluginApplication> pluginApplicationMap = new HashMap<>();

    public static Context loadPluginComponent(PluginClassLoader pluginClassLoader, String component, Context hostContext) {
        Class<?> pluginComponentClass = null;
        try {
            pluginComponentClass = pluginClassLoader.loadClass(component);
        } catch (ClassNotFoundException e) {
            LogUtil.e(TAG, "failed to load component class");
        }
        if (pluginComponentClass == null) {
            return null;
        }

        Constructor pluginComponentConstructor = null;
        try {
            pluginComponentConstructor = pluginComponentClass.getConstructor(Context.class);
        } catch (NoSuchMethodException e) {
            LogUtil.e(TAG, "failed to get constructor of component");
        }
        if (pluginComponentConstructor == null) {
            return null;
        }

        Context pluginComponent = null;
        try {
            pluginComponent = (Context) pluginComponentConstructor.newInstance(hostContext);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            LogUtil.e(TAG, "failed to instantiate plugin component");
        }
        if (pluginComponent == null) {
            return null;
        }

        return pluginComponent;
    }

    public static PluginClassLoader loadPluginClassLoader(
        String pluginName, String apkPath, String optDir, String libDir, ClassLoader hostClassLoader
    ) {
        synchronized (PluginLoader.class) {
            if (pluginClassLoaderMap.containsKey(pluginName)) {
                return pluginClassLoaderMap.get(pluginName);
            } else {
                PluginClassLoader pluginClassLoader = new PluginClassLoader(apkPath, optDir, libDir, hostClassLoader);
                pluginClassLoaderMap.put(pluginName, pluginClassLoader);
                return pluginClassLoader;
            }
        }
    }

    public static PluginApplication loadPluginApplication(
        String pluginName, PluginClassLoader pluginClassLoader, String applicationName, Context hostContext
    ) {
        synchronized (PluginLoader.class) {
            if (pluginApplicationMap.containsKey(pluginName)) {
                return pluginApplicationMap.get(pluginName);
            } else {
                PluginApplication pluginApplication = (PluginApplication) loadPluginComponent(
                    pluginClassLoader, applicationName, hostContext);
                pluginApplicationMap.put(pluginName, pluginApplication);
                return pluginApplication;
            }
        }
    }

    public static PluginResources loadPluginResources(
        String pluginName, String apkPath, Context hostContext
    ) {
        synchronized (PluginLoader.class) {
            if (pluginResourcesMap.containsKey(pluginName)) {
                return pluginResourcesMap.get(pluginName);
            } else {
                PackageManager packageManager = hostContext.getPackageManager();
                ApplicationInfo applicationInfo = null;
                try {
                    applicationInfo = packageManager.getApplicationInfo(hostContext.getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException e) {
                    LogUtil.e(TAG, "failed to get application info of host context");
                }
                if (applicationInfo == null) {
                    return null;
                }
                applicationInfo.sourceDir = apkPath;
                applicationInfo.publicSourceDir = apkPath;
                Resources injectResources = null;
                try {
                    injectResources = packageManager.getResourcesForApplication(applicationInfo);
                } catch (PackageManager.NameNotFoundException e) {
                    LogUtil.e(TAG, "failed to create inject resources");
                }
                if (injectResources == null) {
                    return null;
                }
                PluginResources pluginResources = new PluginResources(hostContext.getResources(), injectResources);
                pluginResourcesMap.put(pluginName, pluginResources);
                return pluginResources;
            }
        }
    }
}
