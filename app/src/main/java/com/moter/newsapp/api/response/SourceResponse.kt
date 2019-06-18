package com.moter.newsapp.api.response

import com.google.gson.annotations.SerializedName
import com.moter.newsapp.model.Source

class SourceResponse : DataResponse<Source>() {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("category")
    var category: String? = null
    @SerializedName("language")
    var language: String? = null
    @SerializedName("country")
    var country: String? = null

    override fun toModel() = Source(
        id = id ?: "",
        name = name ?: "",
        description = description ?:"",
        url = url ?:"",
        category = category ?:"",
        language = language ?:"",
        country = country ?:""

    )
}