package com.picpay.desafio.android.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(users: List<UserEntity>)

    @Query("SELECT * FROM UserEntity ORDER BY id ASC")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT (SELECT COUNT(*) FROM UserEntity) == 0")
    fun isEmpty(): Boolean
}