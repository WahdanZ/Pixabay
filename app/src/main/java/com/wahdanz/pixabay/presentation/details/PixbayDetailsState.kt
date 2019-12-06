package com.wahdanz.pixabay.presentation.details
import com.wahdanz.pixabay.domain.entity.PixbayEntity

sealed class PixbayDetailsState {
    object Loading : PixbayDetailsState()
    data class PixbayData(val data: PixbayEntity) : PixbayDetailsState()
    data class Error(val errorMsg: String) : PixbayDetailsState()
}