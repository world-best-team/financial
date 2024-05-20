@file:Suppress("UnstableApiUsage")

package team.wbt.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose() {
    val libs = versionCatalog

    androidExtension.apply {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose-compiler").get().toString()
        }

        dependencies {
            val bom = libs.findLibrary("compose-bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("implementation", libs.findLibrary("material3").get())
            add("implementation", libs.findLibrary("ui").get())
            add("implementation", libs.findLibrary("ui-util").get())
            add("implementation", libs.findLibrary("ui-tooling-preview").get())
            add("implementation", libs.findLibrary("ui-graphics").get())

            add("debugImplementation", libs.findLibrary("ui-tooling").get())
            add("androidTestImplementation", libs.findLibrary("test-ext-junit").get())
            add("androidTestImplementation", libs.findLibrary("espresso-core").get())
            add("androidTestImplementation", libs.findLibrary("ui-test-junit4").get())
            add("debugImplementation", libs.findLibrary("ui-test-manifest").get())
        }

    }
}