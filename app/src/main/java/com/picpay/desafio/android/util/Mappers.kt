package com.picpay.desafio.android.util

import com.picpay.desafio.android.data.local.UserEntity
import com.picpay.desafio.android.data.remote.User

object Mappers {
    fun List<User>.asEntity(): List<UserEntity> {
        return map {
            UserEntity(
                img = it.img,
                name = it.name,
                id = it.id,
                username = it.username
            )
        }
    }
}