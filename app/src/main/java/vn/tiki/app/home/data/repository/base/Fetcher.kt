package vn.tiki.app.home.data.repository.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Fetcher @Inject constructor() {
    fun <T> fetch(observable: Observable<T>, resultListener: ResultListener<T>): Disposable {
        return observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { resultListener.onRequestStart() }
            .subscribe(
                resultListener::onRequestSuccess,
                resultListener::onRequestError
            )
}
}