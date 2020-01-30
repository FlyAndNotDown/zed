package pers.kindem.zed.runtime.container.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public interface ContainerActivityCallback {
    void pureOnCreate(Bundle savedInstanceState);
    Resources pureGetResources();
    ClassLoader pureGetClassLoader();
    LayoutInflater pureGetLayoutInflater();
    void pureSetContentView(View view);
    void pureSetContentView(int id);
    Resources.Theme pureGetTheme();
    void pureSetTheme(int resid);
}
