package com.wahdanz.pixabay.presentation.di

import com.wahdanz.pixabay.presentation.details.DetailsViewModel
import com.wahdanz.pixabay.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module(override = true) {
    viewModel {
        HomeViewModel(
            get(),
            get(),
            get()
        )
    }
    viewModel {
        DetailsViewModel(
            get(),
            get(),
            get()
        )
    }
}