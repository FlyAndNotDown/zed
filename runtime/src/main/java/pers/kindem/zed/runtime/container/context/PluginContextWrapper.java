package pers.kindem.zed.runtime.container.context;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;

import pers.kindem.zed.runtime.loader.proxy.PluginApplication;
import pers.kindem.zed.runtime.loader.proxy.PluginClassLoader;
import pers.kindem.zed.runtime.loader.proxy.PluginResources;

public class PluginContextWrapper extends ContextWrapper implements PluginContextInject {
    private PluginClassLoader pluginClassLoader;
    private PluginResources pluginResources;
    private PluginApplication pluginApplication;
    private LayoutInflater layoutInflater;
    private Context baseContext;

    public PluginContextWrapper() {
        super(null);
    }

    public PluginContextWrapper(Context base) {
        super(base);
        baseContext = base;
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
    public void setBaseContext(Context baseContext) {
        this.baseContext = baseContext;
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

    @Override
    public Object getSystemService(String name) {
        if (name.equals(LAYOUT_INFLATER_SERVICE)) {
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(this);
            }
            return layoutInflater;
        }
        return null;
    }
}
