import team.wbt.app.configureHiltAndroid
import team.wbt.app.versionCatalog

plugins {
    id("wbt.android.library")
    id("wbt.android.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

configureHiltAndroid()

dependencies {

//    implementation(project(":core:model"))
//    implementation(project(":core:data"))
//    implementation(project(":core:domain"))
    implementation(project(":core:designsystem"))

    val libs = versionCatalog
    implementation(libs.findLibrary("core.ktx").get())
    implementation(libs.findLibrary("appcompat").get())
    implementation(libs.findLibrary("activity.compose").get())
    implementation(libs.findLibrary("navigation.compose").get())
    androidTestImplementation(libs.findLibrary("navigation.testing").get())
    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("lifecycle.runtime.compose").get())
    implementation(libs.findLibrary("lifecycle.viewmodel.compose").get())
}
