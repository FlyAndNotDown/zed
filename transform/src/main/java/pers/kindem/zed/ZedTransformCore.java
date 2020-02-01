package pers.kindem.zed;

import javassist.*;
import org.gradle.api.Project;

import java.io.File;
import java.io.IOException;

public class ZedTransformCore {
    private static String CLASS_NAME_ANDROID_ACTIVITY = "android.app.Activity";
    private static String CLASS_NAME_PLUGIN_ACTIVITY = "pers.kindem.zed.runtime.container.activity.PluginActivity";

    private static String formatClass(String path) {
        return path.substring(path.indexOf("classes" + File.separator) + 8, path.length() - 6).replaceAll(File.separator, ".");
    }

    public static void init() {
        ClassPool.getDefault().makeClass(CLASS_NAME_ANDROID_ACTIVITY);
        ClassPool.getDefault().makeClass(CLASS_NAME_PLUGIN_ACTIVITY);
    }

    public static void transformDir(File dir) throws TransformException {
        String dirPath = "";
        try {
            dirPath = dir.getCanonicalPath();
        } catch (IOException e) {
            throw new TransformException("failed to get canonical path of dir: " + dir.getPath());
        }
        if (dirPath.isEmpty()) {
            return;
        }

        try {
            ClassPool.getDefault().appendClassPath(dirPath);
        } catch (NotFoundException e) {
            throw new TransformException("failed to append classpath of dir: " + dir.getPath());
        }

        if (!dir.isDirectory()) {
            throw new TransformException("file is not a dir: " + dir.getPath());
        }
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                transformDir(file);
            } else if (file.isFile()) {
                transformFile(file);
            }
        }
    }

    public static void transformFile(File file) throws TransformException {
        System.out.println("start transform file: " + file.getPath());

        String filePath = "";
        try {
            filePath = file.getCanonicalPath();
        } catch (IOException e) {
            throw new TransformException("failed to get canonical path of file: " + file.getPath());
        }
        if (filePath.isEmpty()) {
            return;
        }

        String formatClassName = formatClass(filePath);
        try {
            CtClass ctClass = ClassPool.getDefault().getCtClass(formatClassName);
            if (ctClass.getSuperclass().getName().endsWith(CLASS_NAME_ANDROID_ACTIVITY)) {
                CtClass pluginActivityClass = ClassPool.getDefault().getCtClass(CLASS_NAME_PLUGIN_ACTIVITY);
                ctClass.setSuperclass(pluginActivityClass);
                ctClass.writeFile();
            }
        } catch (NotFoundException e) {
            throw new TransformException("failed to get ct class: " + e.getMessage());
        } catch (CannotCompileException e) {
            throw new TransformException("failed to compile class");
        } catch (IOException e) {
            throw new TransformException("failed to write file");
        }
    }
}
