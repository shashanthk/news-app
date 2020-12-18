package com.shashanth.newsapp.data.api

import com.shashanth.newsapp.data.model.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("everything")
    fun getNews(): Call<MutableList<News>>

}