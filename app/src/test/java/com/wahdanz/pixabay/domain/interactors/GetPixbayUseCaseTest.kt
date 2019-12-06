package com.wahdanz.pixabay.domain.interactors

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.wahdanz.pixabay.domain.repository.PixbayRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class GetPixbayUseCaseTest {
    private val mockPixbayRepository: PixbayRepository = mock()

    private lateinit var useCase: GetPixbayUseCase

    @Before
    fun setUp() {
        useCase = GetPixbayUseCase(mockPixbayRepository)
    }

    @Test
    fun `when execute then getPixbay`() {
        runBlocking {
            // when
            useCase.execute(GetPixbayUseCase.Params(id = 1))

            // then
            verify(mockPixbayRepository).getPixbay(1)
        }
    }
}