package pers.kindem.zed.runtime.bean;

import pers.kindem.zed.runtime.utils.StringUtil;

public class PluginInfo {
    private String name;
    private String packageName;
    private String apkPath;
    private String optDir;
    private String libDir;
    private int version;

    public PluginInfo() {
        this.name = "";
        this.packageName = "";
        this.apkPath = "";
        this.optDir = "";
        this.libDir = "";
        this.version = 0;
    }

    public PluginInfo(
        String name,
        String packageName,
        String apkPath,
        String optDir,
        String libDir,
        int version
    ) {
        this.name = name;
        this.packageName = packageName;
        this.apkPath = apkPath;
        this.optDir = optDir;
        this.libDir = libDir;
        this.version = version;
    }

    public boolean selfVerify() {
        return StringUtil.verify(this.name) &&
            StringUtil.verify(this.packageName) &&
            StringUtil.verify(this.apkPath) &&
            StringUtil.verify(this.optDir) &&
            StringUtil.verify(this.libDir) &&
            this.version != 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getApkPath() {
        return apkPath;
    }

    public void setApkPath(String apkPath) {
        this.apkPath = apkPath;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getOptDir() {
        return optDir;
    }

    public void setOptDir(String optDir) {
        this.optDir = optDir;
    }

    public String getLibDir() {
        return libDir;
    }

    public void setLibDir(String libDir) {
        this.libDir = libDir;
    }
}
