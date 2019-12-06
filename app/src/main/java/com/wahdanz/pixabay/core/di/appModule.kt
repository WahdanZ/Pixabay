package com.wahdanz.pixabay.core.di

import com.wahdanz.pixabay.core.exception.DefaultErrorHandler
import com.wahdanz.pixabay.core.exception.ErrorHandler
import com.wahdanz.pixabay.core.executor.CoroutineExecutor
import com.wahdanz.pixabay.core.executor.ExecutionThread
import com.wahdanz.pixabay.core.resource.AppResources
import com.wahdanz.pixabay.core.resource.ResourcesRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single { AppResources(context = androidApplication()) }
    single { ResourcesRepository(get()) }
    factory<ErrorHandler> {
        DefaultErrorHandler(get())
    }
    factory<ExecutionThread> { CoroutineExecutor() }
}