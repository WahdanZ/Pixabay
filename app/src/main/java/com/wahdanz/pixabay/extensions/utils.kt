package com.wahdanz.pixabay.extensions

import android.util.Log

inline fun <reified T : Any> T.debugLog(message: String?) =
    Log.d(T::class.java.simpleName, message ?: "")

inline fun <reified T : Any> T.errorLog(message: String?, error: Throwable? = null) =
    Log.e(T::class.java.simpleName, message ?: "", error)