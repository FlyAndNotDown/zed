package pers.kindem.zed.runtime.container.application;

import android.content.Context;

import pers.kindem.zed.runtime.container.context.PluginContextWrapper;

public class PluginApplication extends PluginContextWrapper {
    public PluginApplication() {
        super(null);
    }

    public PluginApplication(Context hostContext) {
        super(hostContext);
    }
}
