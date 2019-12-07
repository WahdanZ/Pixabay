package com.wahdanz.pixabay.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.wahdanz.pixabay.core.exception.ErrorHandler
import com.wahdanz.pixabay.core.executor.ExecutionThread
import com.wahdanz.pixabay.domain.interactors.GetAllPixbaysUseCase
import com.wahdanz.pixabay.dummy.DummyData
import com.wahdanz.pixabay.mock.MockedCoroutinesExecutor
import com.wahdanz.pixabay.mock.MockedErrorHandler
import com.wahdanz.pixabay.presentation.home.HomeViewModel
import com.wahdanz.pixabay.presentation.home.PixbayHomeState
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.SocketTimeoutException
import java.net.UnknownHostException

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
    fun `test when getting data return state with data`() = runBlocking {
        whenever(getAllPixbaysUseCase.execute(GetAllPixbaysUseCase.Params(query = "test"))).thenReturn(
            listOf(
                DummyData.dummyDomainObject
            )
        )
        homeViewModel.getAllPixbays(query = "test", currentCount = 0)
        assert(
            homeViewModel.state.value == PixbayHomeState.PixbayData(
                query = "test",
                data = listOf(DummyData.dummyDomainObject)
            )
        )
    }

    @Test
    fun `test when getting data return state with load more`() = runBlocking {
        whenever(getAllPixbaysUseCase.execute(GetAllPixbaysUseCase.Params(query = "test"))).thenReturn(
            listOf(
                DummyData.dummyDomainObject
            )
        )
        homeViewModel.getAllPixbays(query = "test", currentCount = 1)
        assert(
            homeViewModel.state.value == PixbayHomeState.PixbayLoadMoreData(
                query = "test",
                data = listOf(DummyData.dummyDomainObject)
            )
        )
    }

    @Test
    fun `test return state with error No internet connection when UnknownHostException happen `() =
        runBlocking {
            whenever(getAllPixbaysUseCase.execute(GetAllPixbaysUseCase.Params(query = "test"))).thenAnswer { throw UnknownHostException() }
            homeViewModel.getAllPixbays(query = "test", currentCount = 0)
            assert(homeViewModel.state.value == PixbayHomeState.Error("No internet connection"))
        }

    @Test
    fun `test return state with error Connection timeout when SocketTimeoutException happen `() =
        runBlocking {
            whenever(getAllPixbaysUseCase.execute(GetAllPixbaysUseCase.Params(query = "test"))).thenAnswer { throw SocketTimeoutException() }
            homeViewModel.getAllPixbays(query = "test", currentCount = 0)
            print(homeViewModel.state.value)
            assert(homeViewModel.state.value == PixbayHomeState.Error("Connection timeout"))
    }
}