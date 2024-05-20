import org.gradle.api.Plugin
import org.gradle.api.Project
import team.wbt.convention.configureAndroidCompose

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")

            configureAndroidCompose()
        }
    }
}