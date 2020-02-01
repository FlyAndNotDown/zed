package pers.kindem.zed;

import com.android.build.api.transform.*;
import com.android.build.gradle.internal.pipeline.TransformManager;
import com.android.utils.FileUtils;
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
    public void transform(TransformInvocation transformInvocation) throws InterruptedException, IOException {
        for (TransformInput transformInput : transformInvocation.getInputs()) {
            for (DirectoryInput directoryInput : transformInput.getDirectoryInputs()) {
                File outputFile = transformInvocation.getOutputProvider().getContentLocation(
                    directoryInput.getName(),
                    directoryInput.getContentTypes(),
                    directoryInput.getScopes(),
                    Format.DIRECTORY
                );
                ZedTransformCore.init();
                try {
                    ZedTransformCore.transformDir(directoryInput.getFile());
                } catch (TransformException e) {
                    project.getLogger().error(e.getMessage());
                }
                FileUtils.copyDirectory(new File(Constant.TRANSFORM_OUTPUT_PATH), outputFile);
            }
        }
    }
}
