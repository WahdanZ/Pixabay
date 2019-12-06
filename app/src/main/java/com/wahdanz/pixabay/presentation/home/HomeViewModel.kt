package com.wahdanz.pixabay.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahdanz.pixabay.Constants
import com.wahdanz.pixabay.core.exception.ErrorHandler
import com.wahdanz.pixabay.core.executor.ExecutionThread
import com.wahdanz.pixabay.domain.interactors.GetAllPixbaysUseCase
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val errorHandler: ErrorHandler,
    private val executionThread: ExecutionThread,

    private val getAllPixbaysUseCase: GetAllPixbaysUseCase
) : ViewModel(), CoroutineScope {
    private val job = Job()
    val state: MutableLiveData<PixbayHomeState> = MutableLiveData()

    init {
        getAllPixbays("fruits", 0)
    }

    override val coroutineContext: CoroutineContext
        get() = executionThread.mainScheduler + job

    fun getAllPixbays(query: String, currentCount: Int) {
        if (state.value == PixbayHomeState.Loading)
            return
        launch(coroutineContext) {
            state.value =
                PixbayHomeState.Loading
            try {
                val result = withContext(executionThread.ioScheduler) {
                     getAllPixbaysUseCase.execute(
                        GetAllPixbaysUseCase.Params(
                            query = query,
                            page = (currentCount / Constants.per_page + 1)
                        )
                    )
                }
                state.value =
                    PixbayHomeState.PixbayData(
                        result
                    )
            } catch (e: Exception) {
                state.value =
                    PixbayHomeState.Error(
                        errorHandler.getErrorMessage(e)
                    )
            }
        }
    }

    override fun onCleared() {
        coroutineContext.cancel()
        super.onCleared()
    }
}