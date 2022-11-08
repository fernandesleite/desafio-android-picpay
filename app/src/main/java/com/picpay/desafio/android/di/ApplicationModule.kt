package com.picpay.desafio.android.di

import com.picpay.desafio.android.util.ResourceUtil
import org.koin.dsl.module

val applicationModule = module {
    factory { ResourceUtil(context = get()) }

}