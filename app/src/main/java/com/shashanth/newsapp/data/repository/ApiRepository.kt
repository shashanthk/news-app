package com.shashanth.newsapp.data.repository

import android.util.Log
import com.shashanth.newsapp.data.api.ApiService
import com.shashanth.newsapp.data.api.IDResponse
import com.shashanth.newsapp.data.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository(private val apiService: ApiService) {

    fun getNews(callback: IDResponse<MutableList<News>>) {
        apiService.getNews().enqueue(object : Callback<MutableList<News>> {
            override fun onResponse(
                call: Call<MutableList<News>>,
                response: Response<MutableList<News>>
            ) {
                Log.i("resp", response.body().toString())
                if (response.isSuccessful) {
                    callback.onSuccess(response.body())
                } else {
                    callback.onError("Unable to get the response")
                }
            }

            override fun onFailure(call: Call<MutableList<News>>, t: Throwable) {
                Log.e("resp", "Error : ", t)
                callback.onError(t.message.orEmpty())
            }
        })
    }

}