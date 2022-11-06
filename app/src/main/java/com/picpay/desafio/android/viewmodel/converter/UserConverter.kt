package com.picpay.desafio.android.viewmodel.converter

import android.widget.Toast
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.local.UserEntity
import com.picpay.desafio.android.util.ResourceUtil
import com.picpay.desafio.android.viewmodel.presentation.ErrorPresentation
import com.picpay.desafio.android.viewmodel.presentation.UserPresentation

class UserConverter(private val resourceUtil: ResourceUtil) {
    private fun getUserPresentation(userData: UserEntity): UserPresentation {

        return UserPresentation.Builder()
            .apply {
                setUserImg(userData.img)
                setPlaceholderImg(R.drawable.ic_round_account_circle)
                setUserName(userData.name)
                setUserUsername(userData.username)
            }.build()
    }

    fun convertUsers(userList: List<UserEntity>): List<UserPresentation> {
        val userPresentations = mutableListOf<UserPresentation>()
        for (user in userList) {
            userPresentations.add(getUserPresentation(user))
        }
        return userPresentations
    }

    fun convertError(): ErrorPresentation {
        return ErrorPresentation.Builder()
            .apply {
                setErrorMessage(resourceUtil.getString(R.string.error))
                setToastLength(Toast.LENGTH_SHORT)
            }.build()
    }
}