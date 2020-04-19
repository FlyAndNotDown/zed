package pers.kindem.zed.runtime.core;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import pers.kindem.zed.runtime.bean.PluginInfo;
import pers.kindem.zed.runtime.utils.FileUtil;
import pers.kindem.zed.runtime.utils.LogUtil;

// TODO remove this class, replace it with PluginPackageManagerService
public class Installer {
    private static final String TAG = Installer.class.getSimpleName();

    public static boolean init(Context context) {
        File pluginsDir = getPluginsDir(context);
        if (!pluginsDir.exists()) {
            if (!pluginsDir.mkdirs()) {
                LogUtil.e(TAG, "failed to make dir " + pluginsDir.getPath());
                return false;
            }
        }
        return true;
    }

    public static String getPluginInstallPath(Context hostContext) {
        return hostContext.getFilesDir().getPath();
    }

    public static PluginInfo getPluginInfo(String name) {
        // TODO query plugin info in PPMS
        if (name.equals("plugin-app")) {
            return new PluginInfo(
                "plugin-app",
                "pers.kindem.zed.plugin-app",
                "/data/data/pers.kindem.host_app/files/plugins/plugin_app__1/base.apk",
                "/data/data/pers.kindem.host_app/files/plugins/plugin_app__1/oat",
                "/data/data/pers.kindem.host_app/files/plugins/plugin_app__1/lib",
                "",
                1
            );
        }
        return null;
    }

    public static boolean copyPluginApkFromAssets(Context context, String apkName) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(apkName);
        } catch (IOException e) {
            LogUtil.e(TAG, "failed to open assert " + apkName);
        }
        if (inputStream == null) {
            return false;
        }
        File installDir = new File(
            getPluginsDirPath(context) + File.separator + apkName.substring(0, apkName.lastIndexOf('.'))
        );
        if (!installDir.exists()) {
            if (!installDir.mkdirs()) {
                LogUtil.e(TAG, "failed to make dir " + installDir.getPath());
                return false;
            }
        }
        OutputStream outputStream = null;
        String destFilePath = installDir.getPath() + File.separator + "base.apk";
        try {
            outputStream = new FileOutputStream(destFilePath);
        } catch (IOException e) {
            LogUtil.e(TAG, "failed to open file " + destFilePath);
        }
        if (outputStream == null) {
            return false;
        }
        FileUtil.copyFile(inputStream, outputStream);
        try {
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            LogUtil.e(TAG, "failed to close inputStream / outputStream");
            return false;
        }
        return true;
    }

    private static File getPluginsDir(Context context) {
        String filesDirPath = context.getFilesDir().getPath();
        return FileUtil.getFile(filesDirPath + File.separator + "plugins");
    }

    private static String getPluginsDirPath(Context context) {
        String filesDirPath = context.getFilesDir().getPath();
        return filesDirPath + File.separator + "plugins";
    }
}
