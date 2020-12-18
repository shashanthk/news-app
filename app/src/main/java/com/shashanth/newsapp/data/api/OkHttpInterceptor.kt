package com.shashanth.newsapp.data.api

import com.shashanth.newsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class OkHttpInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val token = BuildConfig.NEWS_API_TOKEN

        if (token.isEmpty()) {
            throw RuntimeException("Please add NewsAPI access key in your local.properties with the name NEWS_API_TOKEN and rebuild the project")
        }

        var request = chain.request()
        request = request.newBuilder()
            .url(
                request.url
                    .newBuilder()
                    .addQueryParameter("apiKey", token)
                    .build()
            )
            .build()

        return chain.proceed(request)
    }

}