package com.picpay.desafio.android.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.BuildConfig

@Database(entities = [UserEntity::class], version = BuildConfig.VERSION_CODE, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO
}