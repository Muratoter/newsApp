package com.moter.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moter.newsapp.model.Article
import com.moter.newsapp.repository.NewsRepository
import kotlinx.coroutines.launch

/**
 * Created by moter on 16.06.2019.
 */
class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    private val articles = MutableLiveData<List<Article>>()

    private val error = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            runCatching {
                newsRepository.getTopHeadLinesByCountry()
            }.onSuccess {
                articles.value = it
            }.onFailure {
                error.value = it.localizedMessage
            }
        }
    }

    fun getArticles(): MutableLiveData<List<Article>> {
        return articles
    }

    fun getError(): MutableLiveData<String> {
        return error
    }
}