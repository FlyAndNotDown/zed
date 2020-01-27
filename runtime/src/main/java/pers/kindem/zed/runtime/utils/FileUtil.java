package pers.kindem.zed.runtime.utils;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
    private static final String TAG = FileUtil.class.getSimpleName();

    public static File getFile(String name) {
        return new File(name);
    }

    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
        byte[] buffer = new byte[1024];
        int byteRead;
        try {
            while ((byteRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, byteRead);
            }
            outputStream.flush();
        } catch (IOException e) {
            LogUtil.e(TAG, "failed to copy file");
            return false;
        }
        return true;
    }
}
