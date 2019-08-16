package vn.tiki.app.home.data.repository.base

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import vn.tiki.app.home.data.model.wrapper.Result

abstract class BaseUseCase<R, P> {
    var disposable: Disposable? = null

    val result = MutableLiveData<Result<R>>()

    private fun invoke(param: P): Disposable {
        return create(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { result.value = Result.loading() }
            .subscribe({
                result.value = Result.fromData(it)
            }, {
                result.value = Result.fromThrowable(it)
            }
            )
    }

    fun start(param: P) {
        disposable = invoke(param)
    }

    fun cancel() {
        disposable?.dispose()
    }

    val isRunning
        get() =   disposable?.let {
            !it.isDisposed
        } ?: false


    abstract fun create(param: P): Observable<R>


}