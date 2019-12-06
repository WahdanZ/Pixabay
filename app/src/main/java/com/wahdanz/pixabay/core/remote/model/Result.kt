package com.wahdanz.pixabay.core.remote.model

data class Result<out T : Any>(val data: T?)
