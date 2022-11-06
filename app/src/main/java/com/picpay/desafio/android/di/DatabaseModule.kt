package com.picpay.desafio.android.di

import android.app.Application
import androidx.room.Room
import com.picpay.desafio.android.data.local.AppDatabase
import com.picpay.desafio.android.data.local.UserDAO
import org.koin.dsl.module

val databaseModule = module {
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "picpay.database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideUserDao(appDatabase: AppDatabase): UserDAO {
        return appDatabase.userDao()
    }

    single { provideUserDao(appDatabase = get()) }
    single { provideAppDatabase(application = get()) }
}