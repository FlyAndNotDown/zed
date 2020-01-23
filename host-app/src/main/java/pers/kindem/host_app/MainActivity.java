package pers.kindem.host_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pers.kindem.zed.runtime.host.HostStandardActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnStartPluginActivityClicked(View view) {
        Intent intent = new Intent(this, HostStandardActivity.class);
        Bundle pluginLoadInfo = new Bundle();
        pluginLoadInfo.putString("zed:plugin:info:name", "plugin-app");
        pluginLoadInfo.putString("zed:plugin:info:component", "pers.kindem.plugin_app.MainActivity");
        intent.putExtra("zed:plugin:info", pluginLoadInfo);
        startActivity(intent);
    }
}
