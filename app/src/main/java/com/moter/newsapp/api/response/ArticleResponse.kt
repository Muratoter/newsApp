package com.moter.newsapp.api.response

import com.google.gson.annotations.SerializedName
import com.moter.newsapp.model.Article

class ArticleResponse : DataResponse<Article>() {

    @SerializedName("author")
    var author: String? = null
    @SerializedName("content")
    var content: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("publishedAt")
    var publishedAt: String? = null
    @SerializedName("source")
    var sourceResponse: SourceResponse? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("urlToImage")
    var urlToImage: String? = null

    override fun toModel() = Article(
        author = author ?: "",
        content = content ?: "",
        description = description ?: "",
        publishedAt = publishedAt ?: "",
        source = sourceResponse?.toModel() ?: throw IllegalArgumentException("source not found"),
        title = title ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: ""
    )
}