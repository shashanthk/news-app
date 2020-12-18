package com.shashanth.newsapp.base

import android.app.Application
import com.shashanth.newsapp.di.module.appModule
import com.shashanth.newsapp.di.module.repoModule
import com.shashanth.newsapp.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppInstance : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppInstance)
            modules(
                listOf(
                    appModule, repoModule, viewModelModule
                )
            )
        }
    }

}