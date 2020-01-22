package pers.kindem.zed.runtime.loader.proxy;

import android.content.Context;

import pers.kindem.zed.runtime.container.context.PluginContextWrapper;

public class PluginApplication extends PluginContextWrapper {
    public PluginApplication(Context hostContext) {
        super(hostContext);
    }
}
