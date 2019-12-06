object Depends {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"

    object BuildPlugins {
        const val kotlinPlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val androidPlugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    }

    object Lint {
        const val kotlin = "org.jmailen.gradle:kotlinter-gradle:${Versions.kotlinter}"
    }

    object Network {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Retrofit.okHttp}"
        const val okhttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.okHttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}"
        const val retrofitMoshi =
            "com.squareup.retrofit2:converter-moshi:${Versions.Retrofit.moshi}"
        const val okhttpMockServer =
            "com.squareup.okhttp3:mockwebserver:${Versions.Retrofit.okHttp}"

    }

    object Coroutines {
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines.version}"
    }

    object Koin {
        const val android = "org.koin:koin-androidx-scope:${Versions.koinVersion}"
        const val viewModel = "org.koin:koin-androidx-viewmodel:${Versions.koinVersion}"
        const val Test = "org.koin:koin-test:${Versions.koinVersion}"
        const val ext = "org.koin:koin-androidx-ext:${Versions.koinVersion}"
    }

    object Testing {
        const val livedata = "com.jraska.livedata:testing-ktx:1.1.0"
        const val arch = "androidx.arch.core:core-testing:2.0.1"
        const val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinVersion}"
        const val mockitoForKotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.Testing.mockitoForKotlinVersion}"
    }

    object AndroidX {

        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0-alpha01"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta3"
    }

    object Glide {

        const val compiler = "com.github.bumptech.glide:compiler:4.9.0"
        const val glide = "com.github.bumptech.glide:glide:4.9.0"
    }

    object Room {
        const val room = "androidx.room:room-runtime:${Versions.Room.version}"
        const val compiler = "androidx.room:room-compiler:${Versions.Room.version}"
        const val ktx = "androidx.room:room-ktx:${Versions.Room.version}"

    }

}