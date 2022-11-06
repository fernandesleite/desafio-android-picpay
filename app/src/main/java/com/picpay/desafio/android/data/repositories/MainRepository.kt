package com.picpay.desafio.android.data.repositories

import com.picpay.desafio.android.data.local.UserDAO
import com.picpay.desafio.android.data.local.UserEntity
import com.picpay.desafio.android.data.remote.PicPayService
import com.picpay.desafio.android.util.Mappers.asEntity
import com.picpay.desafio.android.util.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MainRepository(private val service: PicPayService, private val dao: UserDAO) {

    suspend fun getUsersLocal(): ResponseState<List<UserEntity>> {
        return withContext(Dispatchers.IO) {
            if (dao.isEmpty()) {
                getUsersRemote()
            } else {
                ResponseState.Success(dao.getAllUsers())
            }
        }
    }

    private suspend fun getUsersRemote(): ResponseState<List<UserEntity>> {
        return withContext(Dispatchers.IO) {
            try {
                val userData = service.getUsers().asEntity()
                dao.insertAllUsers(userData)
                ResponseState.Success(userData)
            } catch (e: HttpException) {
                ResponseState.GenericError(e)
            } catch (e: IOException) {
                ResponseState.NetworkError(e)
            }
        }
    }

}