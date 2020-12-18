package com.shashanth.newsapp.data.api

interface IDResponse<T> {
    fun onSuccess(data: T?)
    fun onError(error: String)
}