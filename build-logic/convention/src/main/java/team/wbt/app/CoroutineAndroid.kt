package team.wbt.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoroutineAndroid() {
    configureCoroutineKotlin()

    val libs = versionCatalog
    dependencies {
        "implementation"(libs.findLibrary("coroutines.android").get())
    }
}