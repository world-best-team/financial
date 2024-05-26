plugins {
    alias(libs.plugins.wbt.android.library)
    alias(libs.plugins.wbt.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "team.wbt.core.network"
}

dependencies {
    api(libs.kotlinx.datetime)

    implementation(libs.bundles.network)
    implementation(libs.kotlinx.serialization.json)
}