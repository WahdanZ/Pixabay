package com.wahdanz.pixabay.data.mapper

import com.wahdanz.pixabay.core.data.mapper.DataMapper
import com.wahdanz.pixabay.data.model.PixabayModel
import com.wahdanz.pixabay.domain.entity.PixbayEntity

class PixabayDataMapper :
    DataMapper<PixbayEntity, PixabayModel> {

    override fun mapFromEntity(type: PixbayEntity): PixabayModel {
        return PixabayModel(
            id = type.id,
            thumbnail = type.thumbnailImage,
            largeImageURL = type.largeImageUrl,
            user = type.user,
            tags = type.tags.joinToString { "," },
            likes = type.likes,
            favorites = type.favorites,
            comments = type.comments,
            downloads = 0,
            type = "",
            pageURL = "",
            previewURL = "",
            userId = 1,
            userImageURL = "",
            views = 1

        )
    }

    override fun mapToEntity(type: PixabayModel): PixbayEntity {
        return PixbayEntity(
            id = type.id, thumbnailImage = type.thumbnail,
            largeImageUrl = type.largeImageURL,
            user = type.user,
            tags = type.tags.split(","),
            likes = type.likes,
            favorites = type.favorites,
            comments = type.comments
        )
    }
}