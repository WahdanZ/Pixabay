package com.wahdanz.pixabay.core.cache.mapper

import com.wahdanz.pixabay.core.data.mapper.DataModel

interface CacheMapper<C : CacheModel, M : DataModel> {
    fun mapFromCached(model: C?): M
    fun mapToCached(entity: M?): C
}