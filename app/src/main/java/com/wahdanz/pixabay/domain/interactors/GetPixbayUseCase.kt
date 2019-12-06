package com.wahdanz.pixabay.domain.interactors

import com.wahdanz.pixabay.core.domain.UseCase
import com.wahdanz.pixabay.domain.entity.PixbayEntity
import com.wahdanz.pixabay.domain.repository.PixbayRepository

class GetPixbayUseCase(private val pixbayRepository: PixbayRepository) :
    UseCase<GetPixbayUseCase.Params, PixbayEntity> {

    data class Params(val id: Int)

    override suspend fun execute(param: Params?): PixbayEntity =
        pixbayRepository.getPixbay(id = param?.id ?: 1)
}