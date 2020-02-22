package pers.kindem.zed.runtime.container.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import pers.kindem.zed.runtime.container.context.PluginContextThemeWrapper;

public class PluginActivity extends BasePluginActivity implements PluginActivityDefined {
    public PluginActivity() {
        super(null);
    }

    public PluginActivity(Context base) {
        super(base);
    }

    public void setContainerActivityCallback(ContainerActivityCallback containerActivityCallback) {
        this.containerActivityCallback = containerActivityCallback;
    }
}
