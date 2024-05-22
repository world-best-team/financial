package team.wbt.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHiltAndroid() {

    with(pluginManager) {
        apply("kotlin-kapt")
        apply("dagger.hilt.android.plugin")
    }

    val libs = versionCatalog

    dependencies {
        add("implementation", libs.findLibrary("hilt.android").get())
        add("kapt", libs.findLibrary("hilt.android.compiler").get())
        add("kaptAndroidTest", libs.findLibrary("hilt.android.compiler").get())
    }
}