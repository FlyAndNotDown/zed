package pers.kindem.zed;

import com.android.build.gradle.AppExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ZedTransformPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project
            .getLogger()
            .info("using zed transform plugin");
        project
            .getExtensions()
            .getByType(AppExtension.class)
            .registerTransform(new ZedTransform(project));
    }
}
