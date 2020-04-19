package pers.kindem.zed.runtime.core.install;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import pers.kindem.zed.runtime.bean.PluginInfo;
import pers.kindem.zed.runtime.utils.Constant;
import pers.kindem.zed.runtime.utils.FileUtil;
import pers.kindem.zed.runtime.utils.LogUtil;
import pers.kindem.zed.runtime.utils.PathUtil;

public class PluginRegister implements IPluginRegister {
    private static final String TAG = PluginRegister.class.getSimpleName();

    private static PluginRegister instance;

    public static PluginRegister getInstance(Context context) {
        if (instance == null) {
            synchronized (PluginRegister.class) {
                if (instance == null) {
                    instance = new PluginRegister(context);
                }
            }
        }
        return instance;
    }

    private Context context;
    private Map<String, PluginInfo> pluginInfoMap = new HashMap<>();

    private PluginRegister(Context context) {
        this.context = context;
    }

    @Override
    public void registerAllPlugins() {
        String pluginsInstallPath = PathUtil.getPluginsInstallPath(context);
        File pluginsInstallDir = FileUtil.getFile(pluginsInstallPath);
        if (!pluginsInstallDir.exists()) {
            LogUtil.e(TAG, "plugins install dir is not exists");
            return;
        }
        String[] children = pluginsInstallDir.list();
        if (children == null) {
            LogUtil.e(TAG, "got none installed plugins");
            return;
        }
        for (String child : children) {
            String childPath = pluginsInstallPath + File.separator + child;
            File childFile = FileUtil.getFile(childPath);
            if (!childFile.isDirectory() || child.matches(Constant.INSTALLED_PLUGIN_DIR_NAME_REGEX)) {
                continue;
            }
            PluginInfo pluginInfo = readPluginInfoFromInstalledPlugin(pluginsInstallPath, childPath);
            if (pluginInfo == null) {
                continue;
            }
            pluginInfoMap.put(pluginInfo.getName(), pluginInfo);
        }
    }

    private PluginInfo readPluginInfoFromInstalledPlugin(String pluginsInstallPath, String installedDirName) {
        String[] tokens = installedDirName.split("__");
        if (tokens.length != 2) {
            LogUtil.e(TAG, "bad dir name");
            return null;
        }
        String name = tokens[0];
        String version = tokens[1];
        String apkPath = pluginsInstallPath + File.separator + installedDirName +
            File.separator + Constant.INSTALLED_PLUGIN_APK_NAME;
        File apkFile = FileUtil.getFile(apkPath);
        if (!apkFile.exists() || !apkFile.isFile()) {
            LogUtil.e(TAG, "found no apk of plugin");
            return null;
        }
        ApplicationInfo applicationInfo = getApplicationInfoFromApk(apkFile.getPath());
        if (applicationInfo == null) {
            LogUtil.e(TAG, "failed to read application info from apk");
            return null;
        }
        return new PluginInfo(
            name,
            applicationInfo.packageName,
            apkPath,
            null,
            null,
            applicationInfo.name,
            Integer.parseInt(version)
        );
    }

    private ApplicationInfo getApplicationInfoFromApk(String apkPath) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
        if (packageInfo == null) {
            LogUtil.e(TAG, "can not get package info from apk");
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            LogUtil.e(TAG, "can not get package info from apk");
            return null;
        }
        return applicationInfo;
    }
}
