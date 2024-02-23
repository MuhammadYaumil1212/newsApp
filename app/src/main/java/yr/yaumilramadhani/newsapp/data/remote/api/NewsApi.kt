package yr.yaumilramadhani.newsapp.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import yr.yaumilramadhani.newsapp.data.remote.dto.NewsResponse
import yr.yaumilramadhani.newsapp.util.Constants.API_KEY

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page")page:Int,
        @Query("sources")sources: String,
        @Query("apiKey") apiKey:String = API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsResponse
}