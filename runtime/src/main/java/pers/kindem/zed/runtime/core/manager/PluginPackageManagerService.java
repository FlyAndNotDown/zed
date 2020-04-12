package pers.kindem.zed.runtime.core.manager;

import android.content.Context;

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

    }
}
