package com.wahdanz.pixabay.data.remote.mapper

import com.wahdanz.pixabay.core.remote.mapper.RemoteMapper
import com.wahdanz.pixabay.data.model.PixabayModel
import com.wahdanz.pixabay.data.remote.model.PixabayItem

class PixabayRemoteMapper :
    RemoteMapper<PixabayItem, PixabayModel> {

    override fun mapFromRemote(type: PixabayItem): PixabayModel {
        return PixabayModel(
            id = type.id ?: 0,
            thumbnail = type.webformatURL ?: "",
            largeImageURL = type.largeImageURL ?: "",
            user = type.user ?: "",
            tags = type.tags ?: "",
            likes = type.likes ?: 0,
            favorites = type.favorites ?: 0,
            comments = type.comments ?: 0,
            downloads = type.downloads ?: 0,
            type = type.type ?: "",
            pageURL = type.pageURL ?: "",
            previewURL = type.previewURL ?: "",
            userId = type.userId ?: 0,
            userImageURL = type.userImageURL ?: "",
            views = type.views ?: 0

        )
    }
}