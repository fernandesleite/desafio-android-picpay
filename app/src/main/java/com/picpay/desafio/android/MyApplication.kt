package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.databaseModule
import com.picpay.desafio.android.di.networkModule
import com.picpay.desafio.android.di.repositoryModule
import com.picpay.desafio.android.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(networkModule, viewModelModule, repositoryModule, databaseModule)
        }
    }
}