package com.hive.fullandroid.repository.remote.api

import com.hive.fullandroid.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserApi {

    @GET("/users")
    @Headers("Content-type: application/json")
    fun getUsers() : Single<List<User>>
}