package com.wahdanz.pixabay.data.cashe.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wahdanz.pixabay.core.cache.mapper.CacheModel

@Entity(tableName = "pixabay_table")
data class PixabayCache(
    @PrimaryKey
    val id: Int = 0,

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

    val user: String = "",

    val views: Int = 0,

    val likes: Int = 0,

    val query: String = ""
):CacheModel