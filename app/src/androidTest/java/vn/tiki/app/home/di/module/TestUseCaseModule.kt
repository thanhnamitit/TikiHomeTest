package vn.tiki.app.home.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import vn.tiki.app.home.data.model.Keyword
import vn.tiki.app.home.data.repository.remote.ApiRepository
import vn.tiki.app.home.data.repository.remote.usecase.FetchKeywordsUseCase
import java.lang.Exception

@Module
class TestUseCaseModule {
    companion object {
        const val TIME_DELAY_IN_MILLIS = 2000L
    }

    @Provides
    fun provideFetchKeywordsUseCase(repository: ApiRepository): FetchKeywordsUseCase {

        return object : FetchKeywordsUseCase(repository) {
            val observables = arrayOf<Observable<List<Keyword>>>(
                Observable.create {
                    Thread.sleep(TIME_DELAY_IN_MILLIS)
                    it.onNext(
                        mutableListOf(
                            Keyword("xiaomi"),
                            Keyword("bitis hunter"),
                            Keyword("bts"),
                            Keyword("balo"),
                            Keyword("bitis hunter x"),
                            Keyword("tai nghe"),
                            Keyword("harry potter"),
                            Keyword("anker"),
                            Keyword("iphone"),
                            Keyword("balo nữ"),
                            Keyword("nguyễn nhật ánh"),
                            Keyword("đắc nhân tâm"),
                            Keyword("senka"),
                            Keyword("ipad"),
                            Keyword("tai nghe bluetooth"),
                            Keyword("son"),
                            Keyword("maybelline"),
                            Keyword("laneige"),
                            Keyword("kem chống nắng"),
                            Keyword("anh chính là thanh xuân của em")
                        )
                    )
                    it.onComplete()
                },
                Observable.create {
                    Thread.sleep(TIME_DELAY_IN_MILLIS)
                    it.onError(Exception("test"))
                }
            )
            var currentIndex = 0
            override fun create(param: Void?): Observable<List<Keyword>> {
                currentIndex = 1 - currentIndex
                return observables[currentIndex]

            }
        }
    }
}
