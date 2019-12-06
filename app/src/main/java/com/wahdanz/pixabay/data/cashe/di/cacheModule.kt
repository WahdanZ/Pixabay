package com.wahdanz.pixabay.data.cashe.di

import com.wahdanz.pixabay.data.cashe.PixbayCacheImpl
import com.wahdanz.pixabay.data.cashe.db.PixabayDatabase
import com.wahdanz.pixabay.data.cashe.mapper.PixabayCacheMapper
import com.wahdanz.pixabay.data.store.PixbayCache
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheModule = module(override = true) {
    single<PixbayCache> { PixbayCacheImpl(get(), get()) }
    factory { PixabayCacheMapper() }
    single { PixabayDatabase.getInstance(context = androidContext()) }
}