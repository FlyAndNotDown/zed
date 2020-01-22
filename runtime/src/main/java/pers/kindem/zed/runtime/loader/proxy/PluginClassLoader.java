package pers.kindem.zed.runtime.loader.proxy;

import dalvik.system.DexClassLoader;

public class PluginClassLoader extends DexClassLoader {
    public PluginClassLoader(
        String apkPath,
        String optDir,
        String libDir,
        ClassLoader hostClassLoader
    ) {
        super(apkPath, optDir, libDir, hostClassLoader);
    }
}
