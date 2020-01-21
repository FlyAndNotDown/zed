package pers.kindem.zed.runtime.container.context;

import android.content.Context;
import android.content.ContextWrapper;

public class PluginContextWrapper extends ContextWrapper {
    public PluginContextWrapper(Context base) {
        super(base);
    }
}
