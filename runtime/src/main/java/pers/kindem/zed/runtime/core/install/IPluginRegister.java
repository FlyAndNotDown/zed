package pers.kindem.zed.runtime.core.install;

import pers.kindem.zed.runtime.bean.PluginInfo;

public interface IPluginRegister {
    void registerAllPlugins();
    PluginInfo getPluginInfo(String pluginName);
}
