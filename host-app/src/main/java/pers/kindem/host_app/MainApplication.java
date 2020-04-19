package pers.kindem.host_app;

import android.app.Application;

import pers.kindem.zed.runtime.core.ZedCore;

public class MainApplication extends Application {
    private static final String TAG = MainApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        ZedCore.getInstance(this).initialize();
    }
}
