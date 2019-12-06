package com.wahdanz.pixabay.data.remote.model

import com.squareup.moshi.Json

data class PixabayResponse(

    @Json(name = "hits")
    val hits: List<PixabayItem>? = null,

    @Json(name = "total")
    val total: Int? = null,

    @Json(name = "totalHits")
    val totalHits: Int? = null
)