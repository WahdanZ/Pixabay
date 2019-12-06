package com.wahdanz.pixabay.core.data.mapper

import com.wahdanz.pixabay.core.domain.Entity

interface DataMapper<E : Entity, D : DataModel> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E
}