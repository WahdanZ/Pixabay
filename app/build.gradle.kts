import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("org.jmailen.kotlinter") version "1.26.0"
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")

}

android {
    compileSdkVersion(Versions.Android.compileSdkVersion)
    defaultConfig {
        applicationId = Config.Application.applicationId
        minSdkVersion(Versions.Android.minSdkVersion)
        targetSdkVersion(Versions.Android.targetSdkVersion)
        versionCode = Config.Application.appVersionCode
        versionName = Config.Application.appVersionName
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
    buildTypes {
        getByName("debug") {

        }
        getByName("release") {

            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation(Depends.AndroidX.constraintlayout)
    implementation(Depends.Network.okhttp)
    implementation(Depends.Network.retrofit)
    implementation(Depends.Network.retrofitMoshi)
    implementation(Depends.Network.okhttpLoggingInterceptor)
    implementation(Depends.Network.okhttpMockServer)
    implementation(Depends.Coroutines.coroutinesAndroid)
    implementation(Depends.Koin.android)
    implementation(Depends.Koin.viewModel)
    implementation(Depends.Koin.ext)
    implementation(Depends.AndroidX.appcompat)
    implementation(Depends.AndroidX.recyclerview)
    implementation(Depends.Glide.glide)
    kapt(Depends.Glide.compiler)
    implementation(Depends.Room.room)
    implementation(Depends.Room.ktx)
    kapt(Depends.Room.compiler)
    testImplementation(Depends.Testing.livedata)
    testImplementation(Depends.Testing.mockitoForKotlin)
    testImplementation(Depends.Testing.junit)
    testImplementation(Depends.Testing.arch)

    implementation(Depends.Koin.Test)


}

repositories {
    mavenCentral()
    maven("http://repository.jetbrains.com/all")
}
