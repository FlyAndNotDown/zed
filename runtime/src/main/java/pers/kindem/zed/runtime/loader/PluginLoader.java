package pers.kindem.zed.runtime.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;

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

        Context pluginComponent = null;
        try {
            pluginComponent = (Context) pluginComponentClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
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
                PluginApplication pluginApplication;
                if (applicationName.isEmpty()) {
                    pluginApplication = new PluginApplication(hostContext);
                } else {
                    pluginApplication = (PluginApplication) loadPluginComponent(
                        pluginClassLoader, applicationName, hostContext);
                }
                pluginApplicationMap.put(pluginName, pluginApplication);
                return pluginApplication;
            }
        }
    }

    public static PluginResources loadPluginResources(
        String pluginName, String apkPath, Context hostApplicationContext
    ) {
        synchronized (PluginLoader.class) {
            if (pluginResourcesMap.containsKey(pluginName)) {
                return pluginResourcesMap.get(pluginName);
            } else {
                PackageManager packageManager = hostApplicationContext.getPackageManager();
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(
                    apkPath, PackageManager.GET_ACTIVITIES |
                        PackageManager.GET_META_DATA |
                        PackageManager.GET_SERVICES |
                        PackageManager.GET_PROVIDERS |
                        PackageManager.GET_SIGNATURES
                );
                if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null) {
                    return null;
                }
                packageArchiveInfo.applicationInfo.sourceDir = apkPath;
                packageArchiveInfo.applicationInfo.publicSourceDir = apkPath;
                Resources injectResources = null;
                try {
                    injectResources = packageManager.getResourcesForApplication(packageArchiveInfo.applicationInfo);
                } catch (PackageManager.NameNotFoundException e) {
                    LogUtil.e(TAG, "failed to create inject resources");
                }
                if (injectResources == null) {
                    return null;
                }
                PluginResources pluginResources = new PluginResources(hostApplicationContext.getResources(), injectResources);
                pluginResourcesMap.put(pluginName, pluginResources);
                return pluginResources;
            }
        }
    }
}
