package com.moter.newsapp.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by moter on 17.06.2019.
 */
class ListSourceResponse<T : Any> {
    @SerializedName("status")
    var status: String? = null
    @SerializedName("sources")
    var sources: List<T>? = null
}