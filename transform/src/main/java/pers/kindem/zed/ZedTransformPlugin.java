package pers.kindem.zed;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ZedTransformPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println("hello");
    }
}
