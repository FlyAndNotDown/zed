package pers.kindem.zed;

import com.android.build.api.transform.*;
import com.android.build.gradle.internal.pipeline.TransformManager;
import com.android.utils.FileUtils;
import javassist.CtClass;
import org.gradle.api.Project;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class ZedTransform extends Transform {
    private Project project;

    public ZedTransform(Project project) {
        this.project = project;
    }

    @Override
    public String getName() {
        return "zed_transform";
    }

    @Override
    public Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS;
    }

    @Override
    public Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT;
    }

    @Override
    public boolean isIncremental() {
        return false;
    }

    @Override
    public void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        for (TransformInput transformInput : transformInvocation.getInputs()) {
            for (DirectoryInput directoryInput : transformInput.getDirectoryInputs()) {
                ZedTransformCore.transformDir(directoryInput.getFile());
                FileUtils.copyDirectory(directoryInput.getFile(), transformInvocation.getOutputProvider().getContentLocation(
                    directoryInput.getName(),
                    directoryInput.getContentTypes(),
                    directoryInput.getScopes(),
                    Format.DIRECTORY
                ));
            }
        }
    }
}
