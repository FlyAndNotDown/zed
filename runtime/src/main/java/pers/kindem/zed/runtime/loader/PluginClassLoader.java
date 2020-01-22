package pers.kindem.zed.runtime.loader;

import java.util.HashMap;
import java.util.Map;

import dalvik.system.DexClassLoader;

public class PluginClassLoader extends DexClassLoader {
    private static final Map<String, PluginClassLoader> classLoaderMap = new HashMap<>();

    private PluginClassLoader(
        String apkPath,
        String optDir,
        String libDir,
        ClassLoader hostClassLoader
    ) {
        super(apkPath, optDir, libDir, hostClassLoader);
    }

    public static PluginClassLoader newInstance(
        String apkPath,
        String optDir,
        String libDir,
        ClassLoader hostClassLoader
    ) {
        synchronized (PluginClassLoader.class) {
            if (classLoaderMap.containsKey(apkPath)) {
                return classLoaderMap.get(apkPath);
            } else {
                PluginClassLoader pluginClassLoader = new PluginClassLoader(
                    apkPath, optDir, libDir, hostClassLoader
                );
                classLoaderMap.put(apkPath, pluginClassLoader);
                return pluginClassLoader;
            }
        }
    }
}
