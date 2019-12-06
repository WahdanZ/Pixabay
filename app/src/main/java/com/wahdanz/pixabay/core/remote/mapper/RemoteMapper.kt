package com.wahdanz.pixabay.core.remote.mapper

import com.wahdanz.pixabay.core.data.mapper.DataModel

interface RemoteMapper<in R : RemoteModel, out M : DataModel> {

    fun mapFromRemote(type: R): M
}