package com.wahdanz.pixabay.data.store

import com.wahdanz.pixabay.data.model.PixabayModel

interface PixbayRemote {
    suspend fun getAllPixbays(page: Int, query: String): List<PixabayModel>
}