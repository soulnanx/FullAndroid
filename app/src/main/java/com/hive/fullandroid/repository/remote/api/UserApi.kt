package com.hive.fullandroid.repository.remote.api

import com.hive.fullandroid.model.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserApi {

    @GET("/users")
    @Headers("Content-type: application/json")
    fun getUsers() : Deferred<Response<List<User>>>
}