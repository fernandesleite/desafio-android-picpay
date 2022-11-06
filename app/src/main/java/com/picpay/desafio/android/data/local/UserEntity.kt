package com.picpay.desafio.android.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    val img: String,
    val name: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val username: String
)
