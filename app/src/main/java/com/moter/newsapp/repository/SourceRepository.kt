package com.moter.newsapp.repository

import com.moter.newsapp.api.NewsService
import com.moter.newsapp.model.Article
import com.moter.newsapp.model.Source

/**
 * Created by moter on 17.06.2019.
 */
class SourceRepository(private val newsService: NewsService) {
    suspend fun getSources(): List<Source> {
        return newsService.getSources().await().sources?.map { sourceResponse ->
            sourceResponse.toModel()

        } ?: emptyList()
    }

    suspend fun getSourceTopHeadLines(sourceId: String): List<Article> {
        return newsService.getSourceNews(sourceId).await().articles?.map { articleResponse ->
            articleResponse.toModel()
        } ?: emptyList()
    }
}