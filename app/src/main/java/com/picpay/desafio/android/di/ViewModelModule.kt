package com.picpay.desafio.android.di

import com.picpay.desafio.android.util.ResourceUtil
import com.picpay.desafio.android.viewmodel.MainViewModel
import com.picpay.desafio.android.viewmodel.converter.UserConverter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(repository = get(), converter = get()) }
    factory { UserConverter(resourceUtil = get()) }
    factory { ResourceUtil(context = get()) }
}