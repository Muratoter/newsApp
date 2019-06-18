package com.moter.newsapp.api

import com.moter.newsapp.api.response.ArticleResponse
import com.moter.newsapp.api.response.ListResponse
import com.moter.newsapp.api.response.ListSourceResponse
import com.moter.newsapp.api.response.SourceResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by moter on 16.06.2019.
 */
interface NewsService {
    @GET("top-headlines")
    fun getTopHeadLinesWithCountry(
        @Query("country") country: String? = "us",
        @Query("apiKey") apikey: String? = Config.API_KEY
    ): Deferred<ListResponse<ArticleResponse>>

    @GET("sources")
    fun getSources(
        @Query("apikey") apikey: String? = Config.API_KEY
    ): Deferred<ListSourceResponse<SourceResponse>>

    @GET("top-headlines")
    fun getSourceNews(
        @Query("sources") sourceId: String,
        @Query("apiKey") apikey: String? = Config.API_KEY
    ): Deferred<ListResponse<ArticleResponse>>
}