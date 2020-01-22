package pers.kindem.zed.runtime.core;

import android.content.Context;

import pers.kindem.zed.runtime.bean.PluginInfo;

public class Installer {
    public static String getPluginInstallPath(Context hostContext) {
        return hostContext.getFilesDir().getPath();
    }

    public static PluginInfo getPluginInfo(String name) {
        // TODO query plugin info in PPMS
        if (name.equals("plugin-1")) {
            return new PluginInfo(
                "plugin-1",
                "pers.kindem.zed.plugin_1",
                "/data/data/pers.kindem.zed.plugin_1/files/plugins/plugin_1__1/base.apk",
                "/data/data/pers.kindem.zed.plugin_1/files/plugins/plugin_1__1/oat",
                "/data/data/pers.kindem.zed.plugin_1/files/plugins/plugin_1__1/lib",
                "",
                1
            );
        }
        return null;
    }
}
