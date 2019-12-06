package com.wahdanz.pixabay.domain.repository

import com.wahdanz.pixabay.domain.entity.PixbayEntity

interface PixbayRepository {
    suspend fun getAllPixbays(page: Int, query: String): List<PixbayEntity>
    suspend fun getPixbay(id: Int): PixbayEntity
}