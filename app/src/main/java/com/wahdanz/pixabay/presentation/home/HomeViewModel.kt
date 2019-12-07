package com.wahdanz.pixabay.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahdanz.pixabay.Constants
import com.wahdanz.pixabay.core.exception.ErrorHandler
import com.wahdanz.pixabay.core.executor.ExecutionThread
import com.wahdanz.pixabay.domain.entity.PixbayEntity
import com.wahdanz.pixabay.domain.interactors.GetAllPixbaysUseCase
import com.wahdanz.pixabay.extensions.debugLog
import com.wahdanz.pixabay.extensions.errorLog
import kotlinx.coroutines.*
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
                debugLog("getAllPixbays query:$query ,page: ${currentCount / Constants.per_page + 1} ")
                val result = getPixbayList(query, currentCount / Constants.per_page + 1)
                debugLog("getAllPixbays $result")
                if (currentCount == 0)
                    state.value =
                        PixbayHomeState.PixbayData(
                            query = query,
                            data = result
                        )
                else {
                    state.value = PixbayHomeState.PixbayLoadMoreData(
                        query = query,
                        data = result
                    )
                }
            } catch (e: Exception) {
                errorLog("getAllPixbays query:$query ,currentCount: $currentCount ", e)
                state.value =
                    PixbayHomeState.Error(
                        errorHandler.getErrorMessage(e)
                    )
            }
        }
    }

    private suspend fun getPixbayList(
        query: String,
        page: Int
    ): List<PixbayEntity> = withContext(executionThread.ioScheduler) {
        getAllPixbaysUseCase.execute(
            GetAllPixbaysUseCase.Params(
                query = query,
                page = page
            )
        )
    }

    fun loadMore(currentCount: Int) {
        debugLog("Load more $currentCount ${state.value}")
        if (state.value is PixbayHomeState.PixbayLoadMoreData)
            getAllPixbays((state.value as PixbayHomeState.PixbayLoadMoreData).query, currentCount)
        if (state.value is PixbayHomeState.PixbayData)
            getAllPixbays((state.value as PixbayHomeState.PixbayData).query, currentCount)
    }

    override fun onCleared() {
        coroutineContext.cancel()
        super.onCleared()
    }
}