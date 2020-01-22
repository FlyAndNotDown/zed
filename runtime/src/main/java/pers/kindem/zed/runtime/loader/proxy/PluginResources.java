package pers.kindem.zed.runtime.loader.proxy;

import android.content.res.Resources;

public class PluginResources extends Resources {
    private Resources hostResources;
    private Resources injectResources;

    public PluginResources(Resources hostResources, Resources injectResources) {
        super(hostResources.getAssets(), hostResources.getDisplayMetrics(), hostResources.getConfiguration());
        this.hostResources = hostResources;
    }
}
