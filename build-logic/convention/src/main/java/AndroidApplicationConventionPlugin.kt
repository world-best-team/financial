import org.gradle.api.Plugin
import org.gradle.api.Project
import team.wbt.convention.applicationExtension
import team.wbt.convention.configureKotlinAndroid
import team.wbt.convention.versionCatalog

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            with(pluginManager) {
                apply("com.android.application")

                configureKotlinAndroid()
            }
        }
    }
}