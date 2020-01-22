package pers.kindem.zed.runtime.container.context;

import pers.kindem.zed.runtime.loader.PluginClassLoader;
import pers.kindem.zed.runtime.loader.PluginResources;

public interface PluginContextInject {
    void setPluginClassLoader(PluginClassLoader pluginClassLoader);
    void setPluginResources(PluginResources pluginResources);
    void setPluginApplication(PluginApplication pluginApplication);
}
