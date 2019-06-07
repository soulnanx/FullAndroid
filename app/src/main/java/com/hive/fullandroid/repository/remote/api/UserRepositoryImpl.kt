package com.hive.fullandroid.repository.remote.api

import com.hive.fullandroid.model.User
import com.hive.fullandroid.repository.remote.apiCreator
import kotlinx.coroutines.Deferred
import retrofit2.Response

class UserRepositoryImpl : UserRepository {
    private val repository = apiCreator.retrofit.create<UserApi>(UserApi::class.java)

    override fun getUser(id: Int) : User?{
        return User(1, "teste")
    }

    override fun getAllUsers(): Deferred<Response<List<User>>> {
        return repository.getUsers()
    }
}