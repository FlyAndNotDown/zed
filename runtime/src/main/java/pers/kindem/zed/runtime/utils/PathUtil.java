package pers.kindem.zed.runtime.utils;

import android.content.Context;

import java.io.File;

public class PathUtil {
    public static String getContextFilesPath(Context context) {
        return context.getFilesDir().getPath();
    }

    public static String getPluginsInstallPath(Context context) {
        return getContextFilesPath(context) + File.separator + Constant.PLUGINS_INSTALL_DIR_NAME;
    }
}
