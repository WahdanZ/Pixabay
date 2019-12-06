package com.wahdanz.pixabay.domain.interactors

import com.wahdanz.pixabay.core.domain.UseCase
import com.wahdanz.pixabay.domain.entity.PixbayEntity
import com.wahdanz.pixabay.domain.repository.PixbayRepository

class GetAllPixbaysUseCase(private val pixbayRepository: PixbayRepository) :
    UseCase<GetAllPixbaysUseCase.Params, List<PixbayEntity>> {

    data class Params(val query: String, val page: Int = 1)

    override suspend fun execute(param: Params?): List<PixbayEntity> =
        pixbayRepository.getAllPixbays(page = param?.page ?: 1, query = param?.query ?: "fruits")
}