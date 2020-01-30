package pers.kindem.zed.runtime.container.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public interface PluginActivityDefined {
    void onCreate(Bundle savedInstanceState);
    Resources getResources();
    void setContentView(View view);
    void setContentView(int id);
    LayoutInflater getLayoutInflater();
}
