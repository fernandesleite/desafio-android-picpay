package com.picpay.desafio.android.util

import android.content.Context
import androidx.core.content.ContextCompat


class ResourceUtil(private val context: Context) {
    fun getString(stringRes: Int) = context.resources.getString(stringRes)
    fun getDrawable(drawableRes: Int) = ContextCompat.getDrawable(context, drawableRes)

}