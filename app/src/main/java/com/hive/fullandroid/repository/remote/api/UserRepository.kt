package com.hive.fullandroid.repository.remote.api

import com.hive.fullandroid.model.User
import io.reactivex.Single

interface UserRepository {
    fun getUser(id: Int) : User?

    fun getAllUsers() : Single<List<User>>
}