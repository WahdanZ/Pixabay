package com.wahdanz.pixabay.domain.di

import com.wahdanz.pixabay.domain.interactors.GetAllPixbaysUseCase
import com.wahdanz.pixabay.domain.interactors.GetPixbayUseCase
import org.koin.dsl.module

val domainModule = module(override = true) {
    factory { GetAllPixbaysUseCase(get()) }
    factory { GetPixbayUseCase(get()) }
}