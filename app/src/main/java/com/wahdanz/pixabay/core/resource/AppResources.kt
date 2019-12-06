package com.wahdanz.pixabay.core.resource

import android.content.Context

class AppResources(private val context: Context) {

    fun getString(resId: Int): String = context.getString(resId)
}