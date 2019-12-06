package com.wahdanz.pixabay.data.store

import com.wahdanz.pixabay.data.model.PixabayModel

interface PixbayCache {
    suspend fun getAllPixbays(query: String): List<PixabayModel>
    suspend fun getPixbay(id: Int): PixabayModel
    suspend fun saveAllPixbays(query:String,pixbays: List<PixabayModel>)
}