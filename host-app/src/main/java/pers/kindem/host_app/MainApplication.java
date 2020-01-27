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
            Log.e(TAG, "failed to init zed installer");
            return;
        }
        if (!Installer.copyPluginApkFromAssets(getApplicationContext(), "plugin_app__1.apk")) {
            Log.e(TAG, "failed to copy apk from assets");
            return;
        }
    }
}
