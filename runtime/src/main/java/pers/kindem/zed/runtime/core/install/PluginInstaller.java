package pers.kindem.zed.runtime.core.install;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import pers.kindem.zed.runtime.core.Installer;
import pers.kindem.zed.runtime.utils.Constant;
import pers.kindem.zed.runtime.utils.FileUtil;
import pers.kindem.zed.runtime.utils.LogUtil;

public class PluginInstaller implements IPluginInstaller {
    private static final String TAG = Installer.class.getSimpleName();

    private static PluginInstaller instance;

    public static PluginInstaller getInstance(Context context) {
        if (instance == null) {
            synchronized (PluginInstaller.class) {
                if (instance == null) {
                    instance = new PluginInstaller(context);
                }
            }
        }
        return instance;
    }

    private Context context;

    private PluginInstaller(Context context) {
        this.context = context;
        init(context);
    }

    @Override
    public boolean installPluginFromAssets(Context context, String apkName) {
        if (!checkPluginApkNameLegal(apkName)) {
            LogUtil.e(TAG, "illegal plugin apk name");
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(apkName);
        } catch (IOException e) {
            LogUtil.e(TAG, "failed to open asset " + apkName);
        }
        if (inputStream == null) {
            LogUtil.e(TAG, "failed to install plugin " + apkName + " from assets");
            return false;
        }
        File installDir = new File(
            getPluginsInstallPath(context) + File.separator + apkName.substring(0, apkName.lastIndexOf('.'))
        );
        if (!installDir.exists()) {
            if (!installDir.mkdirs()) {
                LogUtil.e(TAG, "failed to make dir " + installDir.getParent());
                LogUtil.e(TAG, "failed to install plugin" + apkName + "from assets");
                return false;
            }
        }
        OutputStream outputStream = null;
        String destFilePath = installDir.getPath() + File.separator + Constant.INSTALLED_PLUGIN_NAME;
        try {
            outputStream = new FileOutputStream(destFilePath);
        } catch (IOException e) {
            LogUtil.e(TAG, "failed to open file " + destFilePath);
        }
        if (outputStream == null) {
            LogUtil.e(TAG, "failed to install plugin" + apkName + "from assets");
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
        LogUtil.i(TAG, "install plugin " + apkName + " from assets");
        return true;
    }

    private void init(Context context) {
        checkAndMakePluginsInstallDir(context);
    }

    private void checkAndMakePluginsInstallDir(Context context) {
        File pluginsInstallDir = getPluginsInstallDir(context);
        if (!pluginsInstallDir.exists()) {
            if (!pluginsInstallDir.mkdirs()) {
                LogUtil.e(TAG, "failed to make dir " + pluginsInstallDir.getPath());
            }
        }
    }

    private boolean checkPluginApkNameLegal(String apkName) {
        if (!apkName.endsWith(".apk")) {
            return false;
        }
        String fileName = apkName.substring(0, apkName.lastIndexOf('.'));
        String[] tmp = fileName.split("__");
        if (tmp.length != 2) {
            return false;
        }
        String pluginVersion = tmp[1];
        return pluginVersion.matches(Constant.REGEX_NUMBER);
    }

    private File getPluginsInstallDir(Context context) {
        return FileUtil.getFile(getPluginsInstallPath(context));
    }

    private String getPluginsInstallPath(Context context) {
        String filesDirPath = context.getFilesDir().getPath();
        return filesDirPath + File.separator + Constant.PLUGINS_INSTALL_DIR_NAME;
    }
}
