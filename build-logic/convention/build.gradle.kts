import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "team.wbt.financial.buildlogic"
// Match sourceCompatibility & targetCompatibility with AGP version
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

// Match jvmTarget with AGP version
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

// Dependencies for convention and build-logic
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
}

// Custom gradle plugin field
gradlePlugin {
    /**
     * Register Plugin in plugins block like Sample below
     *
     * register("androidApplication"){
     *      id = "wbt.android.application" // Id to use in build.gradle.kts
     *      implementationClass = "AndroidApplicationConventionPlugin" // Implemented class which extends Plugin<Project>
     * }
     */
    plugins {
        register("androidApplication") {
            id = "wbt.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "wbt.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "wbt.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "wbt.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}