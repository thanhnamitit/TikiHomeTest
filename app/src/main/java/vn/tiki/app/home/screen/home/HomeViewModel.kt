package vn.tiki.app.home.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import vn.tiki.app.home.data.model.Keyword
import vn.tiki.app.home.data.repository.remote.usecase.FetchKeywordsUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(val fetchKeywordsUseCase: FetchKeywordsUseCase) : ViewModel() {

    val keywords: LiveData<List<Keyword>> = Transformations.map(fetchKeywordsUseCase.result) {
        if (it.isSuccess) it.body else null
    }
    val isLoading: LiveData<Boolean> = Transformations.map(fetchKeywordsUseCase.result) {
        it.isLoading
    }

    fun fetchKeywords() {
        fetchKeywordsUseCase.cancel()
        fetchKeywordsUseCase.start()
    }

    fun fetchKeywordIfNotYet() {

    }
}
