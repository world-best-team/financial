plugins {
    alias(libs.plugins.wbt.android.application)
}

android {
    namespace = "team.wbt.financial"

    defaultConfig {
        applicationId = "team.wbt.financial"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":feature:main"))
    implementation(libs.timber)
}