package com.wahdanz.pixabay.data.cashe.mapper

import com.wahdanz.pixabay.core.cache.mapper.CacheMapper
import com.wahdanz.pixabay.data.cashe.dto.PixabayCache
import com.wahdanz.pixabay.data.model.PixabayModel

class PixabayCacheMapper :
    CacheMapper<PixabayCache, PixabayModel> {

    override fun mapFromCached(type: PixabayCache?): PixabayModel {
        return PixabayModel(
            id = type?.id ?: 0,
            thumbnail = type?.thumbnail ?: "",
            largeImageURL = type?.largeImageURL ?: "",
            user = type?.user ?: "",
            tags = type?.tags ?: "",
            likes = type?.likes ?: 0,
            favorites = type?.favorites ?: 0,
            comments = type?.comments ?: 0,
            downloads = type?.downloads ?: 0,
            type = type?.type ?: "",
            pageURL = type?.pageURL ?: "",
            previewURL = type?.previewURL ?: "",
            userId = type?.userId ?: 0,
            userImageURL = type?.userImageURL ?: "",
            views = type?.views ?: 0

        )
    }

    override fun mapToCached(type: PixabayModel?): PixabayCache {
       return PixabayCache(
            id = type?.id ?: 0,
            thumbnail = type?.thumbnail ?: "",
            largeImageURL = type?.largeImageURL ?: "",
            user = type?.user ?: "",
            tags = type?.tags ?: "",
            likes = type?.likes ?: 0,
            favorites = type?.favorites ?: 0,
            comments = type?.comments ?: 0,
            downloads = type?.downloads ?: 0,
            type = type?.type ?: "",
            pageURL = type?.pageURL ?: "",
            previewURL = type?.previewURL ?: "",
            userId = type?.userId ?: 0,
            userImageURL = type?.userImageURL ?: "",
            views = type?.views ?: 0

        )
    }
}