package com.moter.newsapp.api.response

/**
 * Created by moter on 16.06.2019.
 */
abstract class DataResponse<T : Any> {

    abstract fun toModel(): T
}