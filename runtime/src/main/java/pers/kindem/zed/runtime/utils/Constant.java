package pers.kindem.zed.runtime.utils;

public class Constant {
    // log
    public static final String LOG_PREFIX = "zed_";

    // plugin load info
    public static final String KEY_PLUGIN_LOAD_INFO = "zed:plugin:info";
    public static final String KEY_PLUGIN_LOAD_INFO_NAME = "zed:plugin:info:name";
    public static final String KEY_PLUGIN_LOAD_INFO_COMPONENT = "zed:plugin:info:component";

    // file
    public static final String PLUGINS_INSTALL_DIR_NAME = "plugins";
    public static final String INSTALLED_PLUGIN_NAME = "base.apk";

    // regex
    public static final String PLUGIN_APK_NAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]*__[0-9]+.apk$";
    public static final String INSTALLED_PLUGIN_DIR_NAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]*__[0-9]+$";
}
