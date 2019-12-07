package com.wahdanz.pixabay.data.remote

import com.squareup.moshi.Moshi
import com.wahdanz.pixabay.Constants
import com.wahdanz.pixabay.core.remote.service.BaseRemoteRepo
import com.wahdanz.pixabay.data.model.PixabayModel
import com.wahdanz.pixabay.data.remote.mapper.PixabayRemoteMapper
import com.wahdanz.pixabay.data.store.PixbayRemote

class PixbayRemoteImpl(
    private val pixbayApiInterface: PixbayApiInterface,
    moshi: Moshi,
    private val remoteMapper: PixabayRemoteMapper
) : BaseRemoteRepo(moshi), PixbayRemote {

    override suspend fun getAllPixbays(page: Int, query: String): List<PixabayModel> {
        return execute(
            pixbayApiInterface.getImages(
                q = query,
                page = page,
                key = Constants.key,
                per_page = Constants.per_page
            )
        )
         .data
         ?.hits
         ?.map(remoteMapper::mapFromRemote) ?: listOf()
    }
}