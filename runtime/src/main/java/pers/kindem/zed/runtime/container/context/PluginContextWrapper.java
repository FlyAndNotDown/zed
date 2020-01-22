package pers.kindem.zed.runtime.container.context;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

import pers.kindem.zed.runtime.loader.proxy.PluginApplication;
import pers.kindem.zed.runtime.loader.proxy.PluginClassLoader;
import pers.kindem.zed.runtime.loader.proxy.PluginResources;

public class PluginContextWrapper extends ContextWrapper implements PluginContextInject {
    private PluginClassLoader pluginClassLoader;
    private PluginResources pluginResources;
    private PluginApplication pluginApplication;

    public PluginContextWrapper(Context base) {
        super(base);
    }

    @Override
    public void setPluginClassLoader(PluginClassLoader pluginClassLoader) {
        this.pluginClassLoader = pluginClassLoader;
    }

    @Override
    public void setPluginResources(PluginResources pluginResources) {
        this.pluginResources = pluginResources;
    }

    @Override
    public void setPluginApplication(PluginApplication pluginApplication) {
        this.pluginApplication = pluginApplication;
    }

    @Override
    public ClassLoader getClassLoader() {
        return pluginClassLoader;
    }

    @Override
    public Resources getResources() {
        return pluginResources;
    }

    @Override
    public Context getApplicationContext() {
        return pluginApplication;
    }
}
