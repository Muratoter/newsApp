package com.moter.newsapp.repository

import com.moter.newsapp.api.NewsService
import com.moter.newsapp.model.Article

/**
 * Created by moter on 16.06.2019.
 */
class NewsRepository(private val newsService: NewsService) {

    suspend fun getTopHeadLinesByCountry(): List<Article> {
        return newsService.getTopHeadLinesWithCountry().await().articles?.map { articleResponse ->
            articleResponse.toModel()
        } ?: emptyList()
    }

}