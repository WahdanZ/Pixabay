package com.wahdanz.pixabay.core.executor

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutineExecutor : ExecutionThread {
    override val mainScheduler: CoroutineDispatcher
        get() = Dispatchers.Main
    override val ioScheduler: CoroutineDispatcher
        get() = Dispatchers.IO
}
