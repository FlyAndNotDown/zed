package pers.kindem.zed.runtime.core;

import android.content.Context;

import pers.kindem.zed.runtime.bean.PluginInfo;

public class Installer {
    public static String getPluginInstallPath(Context hostContext) {
        return hostContext.getFilesDir().getPath();
    }

    public static PluginInfo getPluginInfo(String name) {
        // TODO query plugin info in PPMS
        if (name.equals("plugin-app")) {
            return new PluginInfo(
                "plugin-app",
                "pers.kindem.zed.plugin-app",
                "/data/data/pers.kindem.zed.plugin_1/files/plugins/plugin_app__1/base.apk",
                "/data/data/pers.kindem.zed.plugin_1/files/plugins/plugin_app__1/oat",
                "/data/data/pers.kindem.zed.plugin_1/files/plugins/plugin_app__1/lib",
                "",
                1
            );
        }
        return null;
    }
}
