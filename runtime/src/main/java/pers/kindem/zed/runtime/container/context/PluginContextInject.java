package pers.kindem.zed.runtime.container.context;

import android.content.Context;

import pers.kindem.zed.runtime.loader.proxy.PluginApplication;
import pers.kindem.zed.runtime.loader.proxy.PluginClassLoader;
import pers.kindem.zed.runtime.loader.proxy.PluginResources;

public interface PluginContextInject {
    void setPluginClassLoader(PluginClassLoader pluginClassLoader);
    void setPluginResources(PluginResources pluginResources);
    void setPluginApplication(PluginApplication pluginApplication);
    void setBaseContext(Context context);
}
