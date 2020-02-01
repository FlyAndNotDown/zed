package pers.kindem.zed.transform;

import com.android.build.gradle.AppExtension;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class ByteCodePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        AppExtension androidAppExtension = project.getExtensions().getByType(AppExtension.class);
        System.out.println("hello");
    }
}
