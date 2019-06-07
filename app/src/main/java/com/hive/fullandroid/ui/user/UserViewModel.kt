package com.hive.fullandroid.ui.user

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hive.fullandroid.model.User
import com.hive.fullandroid.repository.user.SharedPreferencesCustom
import com.hive.fullandroid.repository.remote.api.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

open class UserViewModel(val userRepo : UserRepository,
                         val sharedPref: SharedPreferencesCustom) : ViewModel() {

    val users = MutableLiveData<List<User>>()


    fun tryToFind(){

    }

    fun getUser(){

        val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

        scope.launch {
            try{
                val response = userRepo.getAllUsers().await()
                users.value = response.body()
            } catch (e : Exception){
                e.toString()
            }
        }

    }
}