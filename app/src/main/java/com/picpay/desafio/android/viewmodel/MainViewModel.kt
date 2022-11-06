package com.picpay.desafio.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.local.UserEntity
import com.picpay.desafio.android.data.repositories.MainRepository
import com.picpay.desafio.android.util.ResponseState
import com.picpay.desafio.android.viewmodel.converter.UserConverter
import com.picpay.desafio.android.viewmodel.presentation.ErrorPresentation
import com.picpay.desafio.android.viewmodel.presentation.UserPresentation
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository, private val converter: UserConverter) :
    ViewModel() {

    private val _userPresentation = MutableLiveData<List<UserPresentation>>()
    val userPresentation: LiveData<List<UserPresentation>>
        get() = _userPresentation

    private val _errorPresentation = MutableLiveData<ErrorPresentation>()
    val errorPresentation: LiveData<ErrorPresentation>
        get() = _errorPresentation

    fun getUsers() {
        viewModelScope.launch {
            when (val responseSource: ResponseState<List<UserEntity>> =
                repository.getUsersLocal()) {
                is ResponseState.Success -> {
                    _userPresentation.value =
                        responseSource.data?.let { converter.convertUsers(it) }
                }
                is ResponseState.GenericError -> {
                    _errorPresentation.value = converter.convertError()
                }
                is ResponseState.NetworkError -> {
                    _errorPresentation.value = converter.convertError()
                }
            }
        }

    }

}