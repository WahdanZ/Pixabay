package com.wahdanz.pixabay.data

import com.wahdanz.pixabay.core.executor.catchNonNetworkException
import com.wahdanz.pixabay.data.mapper.PixabayDataMapper
import com.wahdanz.pixabay.data.store.PixbayCache
import com.wahdanz.pixabay.data.store.PixbayRemote
import com.wahdanz.pixabay.domain.entity.PixbayEntity
import com.wahdanz.pixabay.domain.repository.PixbayRepository

class PixbayRepositoryImpl(private val cache: PixbayCache, private val remote: PixbayRemote, private val mapper: PixabayDataMapper) :
    PixbayRepository {

    override suspend fun getAllPixbays(page: Int, query: String): List<PixbayEntity> {
        // todo to be improved and make it Database first
        return catchNonNetworkException(networkCall = {
          val res = remote.getAllPixbays(page, query)
            cache.saveAllPixbays(query,res)
            res.map(mapper::mapToEntity)
        }) {
            cache.getAllPixbays(query).map(mapper::mapToEntity)
        }
    }

    override suspend fun getPixbay(id: Int): PixbayEntity {
        return mapper.mapToEntity(cache.getPixbay(id))
    }
}
