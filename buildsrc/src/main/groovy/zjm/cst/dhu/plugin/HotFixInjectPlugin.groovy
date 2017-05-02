package zjm.cst.dhu.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

public class HotFixInjectPlugin implements Plugin<Project> {


    @Override
    void apply(Project project) {
        println("--->Apply HotFixInjectPlugin")
        def android = project.extensions.findByType(AppExtension)
        android.registerTransform(new HotFixInjectTransform(project))
    }
}