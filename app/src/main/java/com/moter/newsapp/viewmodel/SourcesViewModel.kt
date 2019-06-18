package com.moter.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moter.newsapp.model.Article
import com.moter.newsapp.model.Source
import com.moter.newsapp.repository.SourceRepository
import kotlinx.coroutines.launch

/**
 * Created by moter on 17.06.2019.
 */
class SourcesViewModel(private val sourceRepository: SourceRepository) : ViewModel() {
    private val sources = MutableLiveData<List<Source>>()
    private val sourceNews = MutableLiveData<List<Article>>()
    private val error = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            runCatching {
                sourceRepository.getSources()
            }.onSuccess {
                sources.value = it
            }.onFailure {
                error.value = it.localizedMessage
            }
        }
    }

    fun getSources(): MutableLiveData<List<Source>> {
        return sources
    }

    fun getSourceNewsList(): MutableLiveData<List<Article>> {
        return sourceNews
    }

    fun getError(): MutableLiveData<String> {
        return error
    }

    fun getSourceNews(sourceId: String) {
        viewModelScope.launch {
            runCatching {
                sourceRepository.getSourceTopHeadLines(sourceId)
            }.onSuccess {
                sourceNews.value = it
            }.onFailure {

            }
        }
    }
}