package vn.tiki.app.home.data.model.wrapper

class Result<T>(
    val body: T?,
    val error: Throwable?
) {
    val isLoading
        get() = body == null && error == null
    val isSuccess
        get() = body != null && error == null
    val isError
        get() = body == null && error != null

    companion object {
        fun <T> loading(): Result<T> {
            return Result(null, null)
        }

        fun <T> fromData(body: T): Result<T> {
            return Result(body, null)
        }

        fun <T> fromThrowable(error: Throwable): Result<T> {
            return Result(null, error)
        }
    }
}