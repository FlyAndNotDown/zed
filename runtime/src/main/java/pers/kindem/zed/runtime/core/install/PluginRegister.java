package pers.kindem.zed.runtime.core.install;

import android.content.Context;

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

    private static PluginRegister getInstance(Context context) {
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
        for (String child : children) {
            String childPath = pluginsInstallPath + File.separator + child;
            File childFile = FileUtil.getFile(childPath);
            if (!childFile.isDirectory() || child.matches(Constant.INSTALLED_PLUGIN_DIR_NAME_REGEX)) {
                continue;
            }
            PluginInfo pluginInfo = new PluginInfo();
            String pluginName = "";
            // TODO fill app plugin info to map
            pluginInfoMap.put(pluginName, pluginInfo);
        }
    }
}
