package pers.kindem.zed.runtime.container.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;

import pers.kindem.zed.runtime.bean.PluginInfo;
import pers.kindem.zed.runtime.bean.PluginLoadInfo;
import pers.kindem.zed.runtime.core.Installer;
import pers.kindem.zed.runtime.loader.PluginLoader;
import pers.kindem.zed.runtime.container.application.PluginApplication;
import pers.kindem.zed.runtime.loader.proxy.PluginClassLoader;
import pers.kindem.zed.runtime.loader.proxy.PluginResources;
import pers.kindem.zed.runtime.utils.Constant;

public class ContainerActivity extends BaseContainerActivity {
    private boolean beforeOnCreate = true;

    public ContainerActivity() {}

    private PluginLoadInfo resolvePluginInfo(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String name = bundle.getString(Constant.KEY_PLUGIN_LOAD_INFO_NAME, "");
        String component = bundle.getString(Constant.KEY_PLUGIN_LOAD_INFO_COMPONENT, "");
        if (name.isEmpty() || component.isEmpty()) {
            return null;
        }
        return new PluginLoadInfo(name, component);
    }

    private boolean loadPlugin(PluginLoadInfo pluginLoadInfo) {
        if (pluginLoadInfo == null) {
            return false;
        }
        PluginInfo pluginInfo = Installer.getPluginInfo(pluginLoadInfo.getName());
        if (pluginInfo == null) {
            return false;
        }
        if (!pluginInfo.selfVerify()) {
            return false;
        }

        PluginClassLoader pluginClassLoader = PluginLoader.loadPluginClassLoader(
            pluginInfo.getName(), pluginInfo.getApkPath(), pluginInfo.getOptDir(),
            pluginInfo.getLibDir(), ContainerActivity.class.getClassLoader());
        if (pluginClassLoader == null) {
            return false;
        }
        PluginApplication pluginApplication = PluginLoader.loadPluginApplication(
            pluginInfo.getName(), pluginClassLoader,
            pluginInfo.getApplicationName(), this
        );
        if (pluginApplication == null) {
            return false;
        }
        PluginResources pluginResources = PluginLoader.loadPluginResources(
            pluginInfo.getName(), pluginInfo.getApkPath(), getApplicationContext()
        );
        if (pluginResources == null) {
            return false;
        }

        pluginActivity = (PluginActivity) PluginLoader.loadPluginComponent(
            pluginClassLoader, pluginLoadInfo.getComponent(), this
        );
        if (pluginActivity == null) {
            return false;
        }
        pluginActivity.setPluginClassLoader(pluginClassLoader);
        pluginActivity.setPluginApplication(pluginApplication);
        pluginActivity.setPluginResources(pluginResources);
        pluginActivity.setBaseContext(this);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        beforeOnCreate = true;
        PluginLoadInfo pluginLoadInfo = resolvePluginInfo(savedInstanceState == null ?
            getIntent().getBundleExtra(Constant.KEY_PLUGIN_LOAD_INFO) :
            savedInstanceState.getBundle(Constant.KEY_PLUGIN_LOAD_INFO));
        if (!loadPlugin(pluginLoadInfo)) {
            super.onCreate(null);
            finish();
            return;
        }
        if (pluginActivity != null) {
            pluginActivity.setContainerActivityCallback(this);
            pluginActivity.onCreate(savedInstanceState);
        } else {
            super.onCreate(null);
            finish();
        }
    }

    @Override
    public Resources.Theme getTheme() {
        return pureGetTheme();
    }

    @Override
    public void setTheme(int resid) {
        if (!beforeOnCreate) {
            pureSetTheme(resid);
        }
    }

    @Override
    public Resources getResources() {
        if (pluginActivity == null) {
            return Resources.getSystem();
        }
        return pluginActivity.getResources();
    }

    @Override
    public ClassLoader getClassLoader() {
        if (pluginActivity == null) {
            return pureGetClassLoader();
        }
        return pluginActivity.getClassLoader();
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        if (pluginActivity == null) {
            return pureGetLayoutInflater();
        }
        return pluginActivity.getLayoutInflater();
    }
}
