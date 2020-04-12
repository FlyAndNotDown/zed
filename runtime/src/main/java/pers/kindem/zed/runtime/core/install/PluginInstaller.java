package pers.kindem.zed.runtime.core.install;

import android.content.Context;

import pers.kindem.zed.runtime.core.Installer;

public class PluginInstaller implements IPluginInstaller {
    private static final String TAG = Installer.class.getSimpleName();

    private static PluginInstaller instance;

    public static PluginInstaller getInstance(Context context) {
        if (instance == null) {
            synchronized (PluginInstaller.class) {
                if (instance == null) {
                    instance = new PluginInstaller(context);
                }
            }
        }
        return instance;
    }

    private Context context;

    private PluginInstaller(Context context) {
        this.context = context;
    }

    @Override
    public boolean installPluginFromAssets(Context context, String apkName) {
        // TODO
        return false;
    }
}
