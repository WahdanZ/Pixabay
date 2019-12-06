package com.wahdanz.pixabay.data.model

import com.wahdanz.pixabay.core.data.mapper.DataModel

data class PixabayModel(

    val favorites: Int = 0,

    val thumbnail: String = "",

    val userImageURL: String = "",

    val comments: Int = 0,

    val previewURL: String = "",

    val type: String = "",

    val tags: String = "",

    val userId: Int = 0,

    val downloads: Int = 0,

    val largeImageURL: String = "",

    val pageURL: String = "",

    val id: Int = 0,

    val user: String = "",

    val views: Int = 0,

    val likes: Int = 0
) : DataModel