package com.wahdanz.pixabay.domain.interactors

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.wahdanz.pixabay.domain.repository.PixbayRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Test

class GetAllPixbaysUseCaseTest {
    private val mockPixbayRepository: PixbayRepository = mock()

    private lateinit var useCase: GetAllPixbaysUseCase
    @Before
    fun setUp() {
        useCase = GetAllPixbaysUseCase(mockPixbayRepository)
    }
    @Test
    fun `when execute then getAllPixbays`() {
        runBlocking {
            // when
            useCase.execute(GetAllPixbaysUseCase.Params("fruits", 1))

            // then
            verify(mockPixbayRepository).getAllPixbays(1, "fruits")
        }
    }
}