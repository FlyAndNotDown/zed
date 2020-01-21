package pers.kindem.zed.runtime.container.activity;

import android.content.Context;
import android.os.Bundle;

import pers.kindem.zed.runtime.container.context.PluginContextThemeWrapper;

public class PluginActivity extends PluginContextThemeWrapper implements PluginActivityDefined {
    private ContainerActivityCallback containerActivityCallback;

    public PluginActivity(Context base) {
        super(base);
    }

    public void setContainerActivityCallback(ContainerActivityCallback containerActivityCallback) {
        this.containerActivityCallback = containerActivityCallback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        containerActivityCallback.pureOnCreate(savedInstanceState);
    }
}
