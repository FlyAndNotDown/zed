package pers.kindem.zed.runtime.container.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

public interface ContainerActivityCallback {
    void pureOnCreate(Bundle savedInstanceState);
    Resources pureGetResources();
    void pureSetContentView(View view);
    void pureSetContentView(int id);
}
