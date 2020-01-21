package pers.kindem.zed.runtime.container.activity;

import android.app.Activity;
import android.os.Bundle;

import pers.kindem.zed.runtime.bean.PluginLoadInfo;
import pers.kindem.zed.runtime.utils.Constant;

public class ContainerContainerActivity extends Activity implements ContainerActivityCallback {
    private PluginActivity pluginActivity;

    public ContainerContainerActivity() {}

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
        // TODO
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PluginLoadInfo pluginLoadInfo = resolvePluginInfo(savedInstanceState == null ?
            getIntent().getBundleExtra(Constant.KEY_PLUGIN_LOAD_INFO) :
            savedInstanceState.getBundle(Constant.KEY_PLUGIN_LOAD_INFO));
        if (!loadPlugin(pluginLoadInfo)) {
            // TODO exception
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
