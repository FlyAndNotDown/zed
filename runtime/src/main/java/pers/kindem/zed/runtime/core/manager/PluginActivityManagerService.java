package pers.kindem.zed.runtime.core.manager;

import android.content.Context;

public class PluginActivityManagerService implements IPluginActivityManagerService {
    private static PluginActivityManagerService instance;

    public static PluginActivityManagerService getInstance(Context context) {
        if (instance == null) {
            synchronized (PluginActivityManagerService.class) {
                if (instance == null) {
                    instance = new PluginActivityManagerService(context);
                }
            }
        }
        return instance;
    }

    private Context context;

    private PluginActivityManagerService(Context context) {
        this.context = context;
    }

    @Override
    public void initialize() {

    }
}
