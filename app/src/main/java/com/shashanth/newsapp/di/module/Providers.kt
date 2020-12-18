package com.shashanth.newsapp.di.module

import android.util.Log
import com.shashanth.newsapp.BuildConfig
import com.shashanth.newsapp.data.api.ApiConstants
import com.shashanth.newsapp.data.api.ApiService
import com.shashanth.newsapp.data.api.OkHttpInterceptor
import com.shashanth.newsapp.data.repository.ApiRepository
import com.shashanth.newsapp.ui.news.NewsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.i("retrofit", message)
        }
    })
    httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }
    return httpLoggingInterceptor
}

private fun provideOkHttpInterceptor(): OkHttpInterceptor = OkHttpInterceptor()

private fun provideOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
    okHttpInterceptor: OkHttpInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(okHttpInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(ApiConstants.BASE_URL)
        .client(okHttpClient)
        .build()
}

private fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

val appModule = module {
    single { provideHttpLoggingInterceptor() }
    single { provideOkHttpInterceptor() }
    single { provideOkHttpClient(get(), get()) }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
}

val repoModule = module {
    single {
        ApiRepository(get())
    }
}

val viewModelModule = module {
    viewModel {
        NewsViewModel(get())
    }
}