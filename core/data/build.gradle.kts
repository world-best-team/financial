plugins {
    alias(libs.plugins.wbt.android.library)
    alias(libs.plugins.wbt.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "team.wbt.core.data"
}

dependencies {

    implementation(libs.bundles.network)
    implementation(libs.kotlinx.datetime)
}