package pers.kindem.zed.runtime.container.activity;

import android.app.Activity;
import android.os.Bundle;

public class ContainerContainerActivity extends Activity implements ContainerActivityCallback {
    public ContainerContainerActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void pureOnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
