package com.wahdanz.pixabay.data.cashe

import com.wahdanz.pixabay.data.cashe.db.PixabayDatabase
import com.wahdanz.pixabay.data.cashe.mapper.PixabayCacheMapper
import com.wahdanz.pixabay.data.model.PixabayModel
import com.wahdanz.pixabay.data.store.PixbayCache

class PixbayCacheImpl(
    private val db: PixabayDatabase,
    private val pixabayCacheMapper: PixabayCacheMapper
) : PixbayCache {

    override suspend fun getAllPixbays(query: String): List<PixabayModel> {
        return db.cachedPixabayDao().getAllPixbays(query).map(pixabayCacheMapper::mapFromCached)
    }

    override suspend fun getPixbay(id: Int): PixabayModel {
        return pixabayCacheMapper.mapFromCached(db.cachedPixabayDao().getPixbay(id))
    }

    override suspend fun saveAllPixbays(query: String, pixbays: List<PixabayModel>) {
        db.cachedPixabayDao().saveAllPixbays(pixbays.map(pixabayCacheMapper::mapToCached).map { it.copy(query = query) })
    }
}