package com.wahdanz.pixabay.data.remote.di

import com.squareup.moshi.Moshi
import com.wahdanz.pixabay.core.remote.network.RetrofitFactory
import com.wahdanz.pixabay.data.remote.PixbayApiInterface
import com.wahdanz.pixabay.data.remote.PixbayRemoteImpl
import com.wahdanz.pixabay.data.remote.mapper.PixabayRemoteMapper
import com.wahdanz.pixabay.data.store.PixbayRemote
import org.koin.dsl.module
import retrofit2.Retrofit

val remoteModule = module(override = true) {
    single { Moshi.Builder().build() }
    single { RetrofitFactory.makeRetrofit(true) }
    factory { get<Retrofit>().create(PixbayApiInterface::class.java) }
    factory { PixabayRemoteMapper() }
    factory<PixbayRemote> { PixbayRemoteImpl(get(), get(), get()) }
}