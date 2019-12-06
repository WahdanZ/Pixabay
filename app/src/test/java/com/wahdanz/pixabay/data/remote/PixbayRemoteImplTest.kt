package com.wahdanz.pixabay.data.remote

import com.wahdanz.pixabay.data.remote.di.remoteModule
import com.wahdanz.pixabay.data.store.PixbayRemote
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test

import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.get

class PixbayRemoteImplTest : AutoCloseKoinTest() {
    private lateinit var mockServer: MockWebServer
    private lateinit var pixbayRemote: PixbayRemote
    @Before
    fun before() {
        mockServer = MockWebServer()
        mockServer.start()

        startKoin {
            modules(listOf(remoteModule))
        }
    }
    @Test
    fun `test success response`() = runBlocking {

        val mockedResponse = MockResponse().apply {
            setResponseCode(200)
        }
        mockServer.enqueue(mockedResponse)
        mockServer.takeRequest()
    }
}