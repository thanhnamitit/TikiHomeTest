package vn.tiki.app.home.data.repository.remote.usecase

import io.reactivex.Observable
import vn.tiki.app.home.data.model.Keyword
import vn.tiki.app.home.data.repository.base.BaseUseCase
import vn.tiki.app.home.data.repository.remote.ApiRepository
import javax.inject.Inject

open class FetchKeywordsUseCase(private val apiRepository: ApiRepository) : BaseUseCase<List<Keyword>, Void?>() {
    override fun create(param: Void?): Observable<List<Keyword>> {
        return apiRepository.getKeywords().map { it.map { body -> Keyword(body) } }
    }

    fun start() {
        start(null)
    }
}