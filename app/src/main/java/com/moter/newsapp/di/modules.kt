package com.moter.newsapp.di

import com.moter.newsapp.api.NewsService
import com.moter.newsapp.api.RetrofitClient
import com.moter.newsapp.model.Article
import com.moter.newsapp.model.Source
import com.moter.newsapp.repository.NewsRepository
import com.moter.newsapp.repository.SourceRepository
import com.moter.newsapp.ui.adapter.NewsAdapter
import com.moter.newsapp.ui.adapter.SourceAdapter
import com.moter.newsapp.viewmodel.NewsViewModel
import com.moter.newsapp.viewmodel.SourcesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by moter on 16.06.2019.
 */
private val retrofit = RetrofitClient.instance
private val service = retrofit.create(NewsService::class.java)

val appModule = module {
    viewModel { NewsViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
    factory { (list: List<Source>, listener: SourceAdapter.Listener) -> SourceAdapter(list, get(), listener) }
    factory { (list: List<Article>, listener: NewsAdapter.Listener) -> NewsAdapter(list, get(), listener) }
}

val networkModule = module {
    single { service }
}

val repositoryModule = module {
    single { NewsRepository(get()) }
    single { SourceRepository(get()) }
}