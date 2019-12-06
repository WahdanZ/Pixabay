package com.wahdanz.pixabay.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.wahdanz.pixabay.core.exception.ErrorHandler
import com.wahdanz.pixabay.core.executor.ExecutionThread
import com.wahdanz.pixabay.domain.interactors.GetAllPixbaysUseCase
import com.wahdanz.pixabay.mock.MockedCoroutinesExecutor
import com.wahdanz.pixabay.mock.MockedErrorHandler
import com.wahdanz.pixabay.presentation.home.HomeViewModel
import com.wahdanz.pixabay.presentation.home.PixbayHomeState
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()
    private lateinit var errorHandler: ErrorHandler
    private lateinit var executionThread: ExecutionThread
    private var getAllPixbaysUseCase: GetAllPixbaysUseCase = mock()
    private var homeViewModel: HomeViewModel = mock()
    @Before
    fun setUp() {
        errorHandler = MockedErrorHandler()
        executionThread = MockedCoroutinesExecutor()
        homeViewModel = HomeViewModel(errorHandler, executionThread, getAllPixbaysUseCase)
    }
    @Test
    fun `test get result success`() = runBlocking {
        whenever(getAllPixbaysUseCase.execute(GetAllPixbaysUseCase.Params(query = "test"))).thenReturn(listOf())
        homeViewModel.getAllPixbays(query = "test", currentCount = 0)
        assert(homeViewModel.state.value == PixbayHomeState.PixbayData(listOf()))
    }
}