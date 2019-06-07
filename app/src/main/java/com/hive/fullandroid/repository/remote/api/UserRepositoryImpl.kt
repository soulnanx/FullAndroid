package com.hive.fullandroid.repository.remote.api

import com.hive.fullandroid.model.User
import io.reactivex.Single

class UserRepositoryImpl : UserRepository {
    private val repository = apiCreator.retrofit.create<UserApi>(UserApi::class.java)

    override fun getUser(id: Int) : User?{
        return User(1, "teste")

    }

    override fun getAllUsers(): Single<List<User>> {
        return repository.getUsers()
    }
}