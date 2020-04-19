package pers.kindem.zed.runtime.core.manager;

import android.content.Context;

import pers.kindem.zed.runtime.core.install.PluginInstaller;
import pers.kindem.zed.runtime.core.install.PluginRegister;

public class PluginPackageManagerService implements IPluginPackageManagerService {
    private static PluginPackageManagerService instance;

    public static PluginPackageManagerService getInstance(Context context) {
        if (instance == null) {
            synchronized (PluginPackageManagerService.class) {
                if (instance == null) {
                    instance = new PluginPackageManagerService(context);
                }
            }
        }
        return instance;
    }

    private Context context;

    private PluginPackageManagerService(Context context) {
        this.context = context;
    }

    @Override
    public void initialize() {
        PluginInstaller.getInstance(context).installPluginFromAssets("plugin_app__1.apk");
        PluginRegister.getInstance(context).registerAllPlugins();
    }
}
