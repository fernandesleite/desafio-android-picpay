package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.repositories.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository(service = get(), dao = get()) }
}