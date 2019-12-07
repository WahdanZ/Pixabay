package com.wahdanz.pixabay.presentation.home

import com.wahdanz.pixabay.domain.entity.PixbayEntity

sealed class PixbayHomeState {
    object Loading : PixbayHomeState()
    data class PixbayData(val query: String, val data: List<PixbayEntity>) : PixbayHomeState()
    data class PixbayLoadMoreData(val query: String, val data: List<PixbayEntity>) :
        PixbayHomeState()
    data class Error(val errorMsg: String, val data: List<PixbayEntity> = listOf()) : PixbayHomeState()
}