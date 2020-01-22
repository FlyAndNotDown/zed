package pers.kindem.zed.runtime.container.activity;

import android.app.Activity;
import android.os.Bundle;

import pers.kindem.zed.runtime.bean.PluginInfo;
import pers.kindem.zed.runtime.bean.PluginLoadInfo;
import pers.kindem.zed.runtime.core.Installer;
import pers.kindem.zed.runtime.loader.PluginLoader;
import pers.kindem.zed.runtime.loader.proxy.PluginApplication;
import pers.kindem.zed.runtime.loader.proxy.PluginClassLoader;
import pers.kindem.zed.runtime.loader.proxy.PluginResources;
import pers.kindem.zed.runtime.utils.Constant;

public class ContainerActivity extends Activity implements ContainerActivityCallback {
    private PluginActivity pluginActivity;

    public ContainerActivity() {}

    public PluginLoadInfo resolvePluginInfo(Bundle bundle) {
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

    public boolean loadPlugin(PluginLoadInfo pluginLoadInfo) {
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
            pluginInfo.getName(), pluginInfo.getApkPath(), this
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
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PluginLoadInfo pluginLoadInfo = resolvePluginInfo(savedInstanceState == null ?
            getIntent().getBundleExtra(Constant.KEY_PLUGIN_LOAD_INFO) :
            savedInstanceState.getBundle(Constant.KEY_PLUGIN_LOAD_INFO));
        if (!loadPlugin(pluginLoadInfo)) {
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
    public void pureOnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
