package vn.tiki.app.home.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import vn.tiki.app.home.data.model.Keyword
import vn.tiki.app.home.data.repository.remote.ApiRepository
import vn.tiki.app.home.data.repository.remote.usecase.FetchKeywordsUseCase

@Module
class TestUseCaseModule {
    @Provides
    fun provideFetchKeywordsUseCase(repository: ApiRepository): FetchKeywordsUseCase {
        return object : FetchKeywordsUseCase(repository) {
            override fun create(param: Void?): Observable<List<Keyword>> {
                return Observable.create{
                    it.onNext(
                        mutableListOf(
                            Keyword("hehe")
                        )
                    )
                    it.onComplete()
                }
            }
        }
    }
}
