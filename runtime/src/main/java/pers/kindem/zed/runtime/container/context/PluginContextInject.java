package pers.kindem.zed.runtime.container.context;

import pers.kindem.zed.runtime.loader.proxy.PluginApplication;
import pers.kindem.zed.runtime.loader.proxy.PluginClassLoader;
import pers.kindem.zed.runtime.loader.proxy.PluginResources;

public interface PluginContextInject {
    void setPluginClassLoader(PluginClassLoader pluginClassLoader);
    void setPluginResources(PluginResources pluginResources);
    void setPluginApplication(PluginApplication pluginApplication);
}
