package com.moter.newsapp.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by moter on 16.06.2019.
 */
class ListResponse<T : Any> {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("totalResults")
    var totalResults: Int? = null

    @SerializedName("articles")
    var articles: List<T>? = null
}