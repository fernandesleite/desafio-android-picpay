package com.picpay.desafio.android.viewmodel.presentation

data class ErrorPresentation(
    val errorMessage: String,
    val toastLength: Int
) {
    class Builder {
        private var errorMessage = ""
        private var toastLength = 0

        fun setErrorMessage(errorMessage: String) = apply { this.errorMessage = errorMessage }
        fun setToastLength(toastLength: Int) = apply { this.toastLength = toastLength }

        fun build() = ErrorPresentation(errorMessage, toastLength)
    }
}
