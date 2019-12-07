package com.wahdanz.pixabay.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahdanz.pixabay.core.exception.ErrorHandler
import com.wahdanz.pixabay.core.executor.ExecutionThread
import com.wahdanz.pixabay.domain.interactors.GetPixbayUseCase
import com.wahdanz.pixabay.extensions.debugLog
import com.wahdanz.pixabay.extensions.errorLog
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DetailsViewModel(
    private val errorHandler: ErrorHandler,
    private val executionThread: ExecutionThread,
    private val getPixbayUseCase: GetPixbayUseCase
) : ViewModel(), CoroutineScope {
    private val job = Job()
     val state: MutableLiveData<PixbayDetailsState> = MutableLiveData()
    override val coroutineContext: CoroutineContext
        get() = executionThread.mainScheduler + job

    fun getPixbay(id: Int) {
        if (state.value == PixbayDetailsState.Loading)
            return
        launch(coroutineContext) {
            state.value =
                PixbayDetailsState.Loading
         try {
            val result = withContext(executionThread.ioScheduler) {
                getPixbayUseCase.execute(GetPixbayUseCase.Params(id = id))
            }
             debugLog("getPixbay $result")
             state.value =
                 PixbayDetailsState.PixbayData(
                     result
                 )
         } catch (e: Exception) {
             errorLog("getPixbay id:$id ", e)

             state.value =
                 PixbayDetailsState.Error(
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