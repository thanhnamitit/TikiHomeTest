package vn.tiki.app.home.data.repository.base

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import vn.tiki.app.home.data.model.wrapper.Result

abstract class BaseUseCase<R, P> {
    @Inject
    lateinit var fetcher: Fetcher

    var disposable: Disposable? = null

    val result = MutableLiveData<Result<R>>()

    private fun invoke(param: P): Disposable {
        return fetcher.fetch(create(param), object : ResultListener<R> {
            override fun onRequestSuccess(response: R) {
                result.value = Result.fromData(response)
            }

            override fun onRequestStart() {
                result.value = Result.loading()
            }

            override fun onRequestError(error: Throwable) {
                result.value = Result.fromThrowable(error)

            }
        })
    }

    fun start(param: P) {
        disposable = invoke(param)
    }

    fun cancel() {
        disposable?.dispose()
    }

    abstract fun create(param: P): Observable<R>

}