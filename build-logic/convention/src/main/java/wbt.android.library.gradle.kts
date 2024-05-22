import team.wbt.app.configureKotest
import team.wbt.app.configureKotlinAndroid
import team.wbt.app.configureCoroutineAndroid

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureKotest()
configureCoroutineAndroid()