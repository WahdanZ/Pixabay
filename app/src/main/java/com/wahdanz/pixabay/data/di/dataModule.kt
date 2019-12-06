package com.wahdanz.pixabay.data.di

import com.wahdanz.pixabay.data.PixbayRepositoryImpl
import com.wahdanz.pixabay.data.mapper.PixabayDataMapper
import com.wahdanz.pixabay.domain.repository.PixbayRepository
import org.koin.dsl.module

val dataModule = module(override = true) {
    factory { PixabayDataMapper() }
    factory<PixbayRepository> { PixbayRepositoryImpl(get(), get(), get()) }
}