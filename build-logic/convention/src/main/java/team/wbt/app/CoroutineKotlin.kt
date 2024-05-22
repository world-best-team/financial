package team.wbt.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoroutineKotlin() {
    val libs = versionCatalog

    dependencies {
        add("implementation", libs.findLibrary("kotlinx.coroutines.core").get())
        add("testImplementation", libs.findLibrary("kotlinx.coroutines.test").get())
    }
}