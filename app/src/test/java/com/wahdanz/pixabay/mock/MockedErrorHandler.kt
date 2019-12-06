package com.wahdanz.pixabay.mock

import com.wahdanz.pixabay.core.exception.ErrorHandler
import com.wahdanz.pixabay.core.remote.exception.NetworkException
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MockedErrorHandler : ErrorHandler {
    override fun getErrorMessage(error: Throwable): String {

        return when (error) {
            is IOException, is UnknownHostException, is SocketException
            -> "No internet connection"
            is SocketTimeoutException -> {
                "Connection timeout"
            }
            is NetworkException -> {
                error.error ?: "Unknown error"
            }
            else -> "Unknown error"
        }
    }
}