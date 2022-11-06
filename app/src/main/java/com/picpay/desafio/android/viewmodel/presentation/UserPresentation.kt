package com.picpay.desafio.android.viewmodel.presentation

import androidx.annotation.DrawableRes

data class UserPresentation(
    val userImg: String,
    @DrawableRes val placeholderImg: Int,
    val userName: String,
    val userUsername: String,
    val progressBarVisibility: Int,
    val visibilityItem: Int
) {
    class Builder {
        private var userImg = ""
        private var placeholderImg = 0
        private var userName = ""
        private var userUsername = ""
        private var progressBarVisibility = 0
        private var visibilityItem = 0

        fun setUserImg(userImg: String) = apply { this.userImg = userImg }
        fun setPlaceholderImg(placeholderImg: Int) = apply { this.placeholderImg = placeholderImg }
        fun setUserName(userName: String) = apply { this.userName = userName }
        fun setUserUsername(userUsername: String) = apply { this.userUsername = userUsername }

        fun build() = UserPresentation(
            userImg,
            placeholderImg,
            userName,
            userUsername,
            progressBarVisibility,
            visibilityItem
        )

    }
}
