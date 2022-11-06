package com.picpay.desafio.android.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.data.remote.PicPayService
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    fun provideService(retrofit: Retrofit): PicPayService {
        return retrofit.create(PicPayService::class.java)
    }

    fun provideRetrofit(url: String, okHttp: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    fun provideApiUrl() = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

    single(named("apiUrl")) { provideApiUrl() }
    single { provideGson() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(named("apiUrl")), okHttp = get(), gson = get()) }
    single { provideService(retrofit = get()) }
}