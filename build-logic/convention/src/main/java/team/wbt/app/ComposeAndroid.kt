package team.wbt.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureComposeAndroid() {
    val libs = versionCatalog

    with(pluginManager) {
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    androidExtension.apply {
        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = libs.findLibrary("compose.bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("implementation", libs.findLibrary("material3").get())
            add("implementation", libs.findLibrary("ui").get())
            add("implementation", libs.findLibrary("ui.util").get())
            add("implementation", libs.findLibrary("ui.tooling-preview").get())
            add("implementation", libs.findLibrary("ui.graphics").get())
            add("implementation", libs.findLibrary("coil.compose").get())

            add("debugImplementation", libs.findLibrary("ui.tooling").get())
            add("androidTestImplementation", libs.findLibrary("test.ext.junit").get())
            add("androidTestImplementation", libs.findLibrary("espresso.core").get())
            add("androidTestImplementation", libs.findLibrary("ui.test.junit4").get())
            add("debugImplementation", libs.findLibrary("ui.test.manifest").get())
        }
    }
}