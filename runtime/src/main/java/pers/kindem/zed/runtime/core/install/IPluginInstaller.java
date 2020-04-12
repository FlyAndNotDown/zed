package pers.kindem.zed.runtime.core.install;

import android.content.Context;

import java.util.List;

public interface IPluginInstaller {
    boolean installPluginFromAssets(Context context, String apkName);
}
