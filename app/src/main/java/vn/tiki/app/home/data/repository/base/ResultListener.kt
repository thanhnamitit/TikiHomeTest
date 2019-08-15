package vn.tiki.app.home.data.repository.base

interface ResultListener<T> {

    fun onRequestStart()

    fun onRequestSuccess(response: T)

    fun onRequestError(error: Throwable)

}