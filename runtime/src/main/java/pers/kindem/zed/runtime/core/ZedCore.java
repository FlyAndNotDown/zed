package pers.kindem.zed.runtime.core;

import android.content.Context;

import pers.kindem.zed.runtime.core.manager.IPluginActivityManagerService;
import pers.kindem.zed.runtime.core.manager.IPluginPackageManagerService;
import pers.kindem.zed.runtime.core.manager.PluginActivityManagerService;
import pers.kindem.zed.runtime.core.manager.PluginPackageManagerService;

public class ZedCore {
    private static ZedCore instance;

    public static ZedCore getInstance(Context context) {
        if (instance == null) {
            synchronized (ZedCore.class) {
                if (instance == null) {
                    instance = new ZedCore(context);
                }
            }
        }
        return instance;
    }

    private Context context;

    private ZedCore(Context context) {
        this.context = context;
    }

    public void initialize() {
        getPluginActivityManagerService().initialize();
        getPluginPackageManagerService().initialize();
    }

    public IPluginActivityManagerService getPluginActivityManagerService() {
        return PluginActivityManagerService.getInstance(context);
    }

    public IPluginPackageManagerService getPluginPackageManagerService() {
        return PluginPackageManagerService.getInstance(context);
    }
}
