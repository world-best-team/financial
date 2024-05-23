pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "financial"
include(":app")
//include(":core:data")
//include(":core:domain")
//include(":core:model")
include(":core:designsystem")
//include(":core:network")
include(":feature:main")
