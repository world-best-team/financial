plugins {
    alias(libs.plugins.wbt.android.feature)
}

android {
    namespace = "team.wbt.feature.main"
}

dependencies {
    // implementation(feature....)
    implementation(project(":core:designsystem"))

    implementation(libs.kotlinx.collections.immutable)
}