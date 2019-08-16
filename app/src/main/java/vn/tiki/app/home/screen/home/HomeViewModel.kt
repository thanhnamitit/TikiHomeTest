package vn.tiki.app.home.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import vn.tiki.app.home.data.model.Keyword
import vn.tiki.app.home.data.model.wrapper.Result
import vn.tiki.app.home.data.repository.remote.usecase.FetchKeywordsUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val fetchKeywordsUseCase: FetchKeywordsUseCase) : ViewModel() {

    val keywords: LiveData<List<Keyword>> = Transformations.map(fetchKeywordsUseCase.result) {
        if (it.isSuccess) it.body else null
    }

    val result: LiveData<Result<List<Keyword>>> = Transformations.map(fetchKeywordsUseCase.result) { it }

    fun fetchKeywords() {
        fetchKeywordsUseCase.cancel()
        fetchKeywordsUseCase.start()
    }

    fun fetchKeywordIfNotYet() {
        if (!fetchKeywordsUseCase.isRunning && keywords.value == null)
            fetchKeywords()
    }
}
