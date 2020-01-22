package pers.kindem.zed.runtime.loader;

import android.content.Context;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import pers.kindem.zed.runtime.loader.proxy.PluginClassLoader;
import pers.kindem.zed.runtime.utils.LogUtil;

public class PluginLoader {
    private static final String TAG = PluginLoader.class.getSimpleName();
    
    public static Context loadComponent(PluginClassLoader pluginClassLoader, String component, Context hostContext) {
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
}
