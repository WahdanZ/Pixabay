package com.wahdanz.pixabay.mock

import com.wahdanz.pixabay.core.executor.ExecutionThread
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class MockedCoroutinesExecutor : ExecutionThread {
    override val mainScheduler: CoroutineDispatcher
        get() = Dispatchers.Unconfined
    override val ioScheduler: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}