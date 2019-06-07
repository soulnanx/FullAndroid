package com.hive.fullandroid.repository.remote.api

import com.hive.fullandroid.model.User
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface UserRepository {
    fun getUser(id: Int) : User?

    fun getAllUsers() : Deferred<Response<List<User>>>
}