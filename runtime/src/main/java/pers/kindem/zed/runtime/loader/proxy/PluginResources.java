package pers.kindem.zed.runtime.loader.proxy;

import android.content.res.Resources;

public class PluginResources extends Resources {
    private Resources hostResources;

    public PluginResources(Resources hostResources) {
        super(hostResources.getAssets(), hostResources.getDisplayMetrics(), hostResources.getConfiguration());
        this.hostResources = hostResources;
    }
}
