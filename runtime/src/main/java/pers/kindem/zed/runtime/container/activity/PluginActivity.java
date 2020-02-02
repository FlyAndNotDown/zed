package pers.kindem.zed.runtime.container.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import pers.kindem.zed.runtime.container.context.PluginContextThemeWrapper;

public class PluginActivity extends PluginContextThemeWrapper implements PluginActivityDefined {
    private ContainerActivityCallback containerActivityCallback;

    public PluginActivity() {
        super(null);
    }

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

    @Override
    public void setContentView(View view) {
        containerActivityCallback.pureSetContentView(view);
    }

    @Override
    public void setContentView(int id) {
        containerActivityCallback.pureSetContentView(id);
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    }
}
