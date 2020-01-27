package pers.kindem.host_app;

import android.app.Application;
import android.util.Log;

import pers.kindem.zed.runtime.core.Installer;

public class MainApplication extends Application {
    private static final String TAG = MainApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        if (!Installer.init(getApplicationContext())) {
            Log.i(TAG, "failed to init zed installer");
        }
        Installer.copyPluginApkFromAsserts(getApplicationContext(), "pers.kindem.plugin_app__1.apk");
    }
}
