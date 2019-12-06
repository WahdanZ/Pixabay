package com.wahdanz.pixabay.core.exception
interface ErrorHandler {
    fun getErrorMessage(error: Throwable): String
}