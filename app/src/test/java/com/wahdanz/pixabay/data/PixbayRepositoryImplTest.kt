package com.wahdanz.pixabay.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.wahdanz.pixabay.core.remote.exception.NetworkException
import com.wahdanz.pixabay.data.mapper.PixabayDataMapper
import com.wahdanz.pixabay.data.store.PixbayCache
import com.wahdanz.pixabay.data.store.PixbayRemote
import com.wahdanz.pixabay.domain.repository.PixbayRepository
import com.wahdanz.pixabay.dummy.DummyData
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.net.SocketTimeoutException

class PixbayRepositoryImplTest {
    private val remote: PixbayRemote = mock()
    private val cache: PixbayCache = mock()
    lateinit var pixbayRepository: PixbayRepository

    @Before
    fun setUp() {
        pixbayRepository = PixbayRepositoryImpl(remote = remote, cache = cache, mapper = PixabayDataMapper())
    }

    @Test
    fun `test get data from remote`() {
        runBlocking {

            whenever(remote.getAllPixbays(page = 1, query = "fruits")).thenReturn(listOf())
            pixbayRepository.getAllPixbays(page = 1, query = "fruits")
            verify(remote, Mockito.times(1)).getAllPixbays(page = 1, query = "fruits")
            verify(cache, Mockito.times(0)).getAllPixbays(query = "fruits")
        }
    }
    @Test
    fun `test get data from cache when no internet connection`() {
        runBlocking {
            whenever(remote.getAllPixbays(page = 1, query = "fruits")).thenAnswer { throw SocketTimeoutException() }
            whenever(remote.getAllPixbays(page = 1, query = "fruits")).thenReturn(listOf())
            pixbayRepository.getAllPixbays(page = 1, query = "fruits")
            verify(remote, Mockito.times(1)).getAllPixbays(page = 1, query = "fruits")
            verify(cache, Mockito.times(1)).getAllPixbays(query = "fruits")
        }
    }
    @Test(expected = NetworkException::class)
    fun `test throw NetworkException when the request not success`() {
        runBlocking {
            whenever(remote.getAllPixbays(page = 1, query = "fruits")).thenAnswer { throw NetworkException() }
            pixbayRepository.getAllPixbays(page = 1, query = "fruits")
            verify(remote, Mockito.times(1)).getAllPixbays(page = 1, query = "fruits")
            verify(cache, Mockito.times(0)).getAllPixbays(query = "fruits")
        }
    }

    @Test
    fun `test get pixbay form cache`() {
        runBlocking {
            whenever(cache.getPixbay(id = 1)).thenReturn(DummyData.dummyDataObject)
            pixbayRepository.getPixbay(id = 1)
            verify(remote, Mockito.times(0)).getAllPixbays(page = 1, query = "fruits")
            verify(cache, Mockito.times(1)).getAllPixbays(query = "fruits")
        }
    }
}