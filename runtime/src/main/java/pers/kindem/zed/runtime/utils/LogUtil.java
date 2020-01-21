package pers.kindem.zed.runtime.utils;

import android.util.Log;

public class LogUtil {
    public static final void v(String info, String tag) {
        Log.v(info, Constant.LOG_PREFIX + tag);
    }

    public static final void d(String info, String tag) {
        Log.d(info, Constant.LOG_PREFIX + tag);
    }

    public static final void i(String info, String tag) {
        Log.i(info, Constant.LOG_PREFIX + tag);
    }

    public static final void w(String info, String tag) {
        Log.w(info, Constant.LOG_PREFIX + tag);
    }

    public static final void e(String info, String tag) {
        Log.e(info, Constant.LOG_PREFIX + tag);
    }
}
