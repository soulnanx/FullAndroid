package com.hive.fullandroid.ui.user

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.hive.fullandroid.repository.user.SharedPreferencesCustom
import com.hive.fullandroid.repository.remote.api.UserRepository
import com.hive.fullandroid.util.rx.SchedulerProvider

open class UserViewModel(val userRepo : UserRepository,
                         val sharedPref: SharedPreferencesCustom,
                         val scheduler: SchedulerProvider
) : ViewModel() {



    fun tryToFind(){

    }

    fun getUser(){

        userRepo.getAllUsers().with(scheduler)

        userRepo.getAllUsers()
    }
}