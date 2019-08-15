package vn.tiki.app.home.data.repository.remote

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiRepository {
    companion object {
        const val API_URL = "https://raw.githubusercontent.com/"
        const val API_GET_KEYWORDS = "tikivn/android-home-test/v2/keywords.json"
    }

    @GET(API_GET_KEYWORDS)
    fun getKeywords() : Observable<List<String>>

}
