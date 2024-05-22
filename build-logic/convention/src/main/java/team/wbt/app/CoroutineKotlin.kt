package team.wbt.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoroutineKotlin() {
    val libs = versionCatalog

    dependencies {
        add("implementation", libs.findLibrary("coroutines.core").get())
        add("testImplementation", libs.findLibrary("coroutines.test").get())
    }
}