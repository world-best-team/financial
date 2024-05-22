import team.wbt.app.configureKotlinAndroid
import team.wbt.app.configureKotestAndroid
import team.wbt.app.configureHiltAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotestAndroid()
