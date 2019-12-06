package com.wahdanz.pixabay.domain.entity

import com.wahdanz.pixabay.core.domain.Entity

data class PixbayEntity(
    val id: Int,
    val thumbnailImage: String,
    val largeImageUrl: String,
    val user: String,
    val tags: List<String>,
    val likes: Int,
    val favorites: Int,
    val comments: Int
) : Entity