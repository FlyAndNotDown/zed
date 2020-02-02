package pers.kindem.zed;

import javassist.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static pers.kindem.zed.Constant.*;

public class ZedTransformCore {
    private static ClassMap transformClassMap = new ClassMap();

    static {
        transformClassMap.put(CLASS_NAME_ANDROID_ACTIVITY, CLASS_NAME_PLUGIN_ACTIVITY);
        transformClassMap.put(CLASS_NAME_ANDROID_CONTEXT, CLASS_NAME_PLUGIN_CONTEXT);
    }

    private static String formatClass(String path) {
        return path.substring(path.indexOf("classes" + File.separator) + 8, path.length() - 6).replaceAll(File.separator, ".");
    }

    public static void init() {
        ClassPool.getDefault().makeClass(CLASS_NAME_ANDROID_ACTIVITY);
        ClassPool.getDefault().makeClass(CLASS_NAME_PLUGIN_ACTIVITY);
        ClassPool.getDefault().makeClass(CLASS_NAME_ANDROID_CONTEXT);
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
            CtClass targetClass = ClassPool.getDefault().getCtClass(formatClassName);
            if (targetClass.isFrozen()) {
                targetClass.defrost();
            }

            if (targetClass.getSuperclass().getName().endsWith(CLASS_NAME_ANDROID_ACTIVITY)) {
                CtClass pluginActivityClass = ClassPool.getDefault().getCtClass(CLASS_NAME_PLUGIN_ACTIVITY);
                targetClass.setSuperclass(pluginActivityClass);

                CtConstructor ctConstructor = targetClass.getDeclaredConstructor(null);
                ctConstructor.setModifiers(Modifier.PUBLIC);
            }

            targetClass.replaceClassName(transformClassMap);
            targetClass.writeFile(TRANSFORM_OUTPUT_PATH);
        } catch (NotFoundException e) {
            throw new TransformException("failed to get ct class: " + e.getMessage());
        } catch (CannotCompileException e) {
            throw new TransformException("failed to compile class: " + e.getMessage());
        } catch (IOException e) {
            throw new TransformException("failed to write file");
        }
    }
}
