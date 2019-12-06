package com.wahdanz.pixabay

import android.app.Application
import com.wahdanz.pixabay.core.di.appModule
import com.wahdanz.pixabay.data.cashe.di.cacheModule
import com.wahdanz.pixabay.data.di.dataModule
import com.wahdanz.pixabay.data.remote.di.remoteModule
import com.wahdanz.pixabay.domain.di.domainModule
import com.wahdanz.pixabay.presentation.di.presentationModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

import org.koin.core.context.startKoin

class PixbayApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PixbayApp)
            modules(listOf(dataModule, remoteModule,
                cacheModule, appModule, domainModule, presentationModule))
        }
    }
}