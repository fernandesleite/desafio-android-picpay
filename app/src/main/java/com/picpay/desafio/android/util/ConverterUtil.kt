package com.picpay.desafio.android.util

import android.view.View

class ConverterUtil {
    companion object {
        fun setVisibility(visibility: Boolean): Int {
            return if(visibility) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }
}