@file:Suppress("DSL_SCOPE_VIOLATION")
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.serialization) apply false
//    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
//    alias(libs.plugins.android.test) apply false
//    alias(libs.plugins.android.navigation.safeargs) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.gms) apply false
}