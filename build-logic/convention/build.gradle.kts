import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

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
    compileOnly(libs.gradle)
}

// Custom gradle plugin field
gradlePlugin {
    /**
     * Register Plugin in plugins block like Sample below
     *
     * register("androidApplication"){
     *      id = "huray.android.application" // Id to use in build.gradle.kts
     *      implementationClass = "AndroidApplicationConventionPlugin" // Implemented class which extends Plugin<Project>
     * }
     */
    plugins {  }
}