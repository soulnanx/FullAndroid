package com.hive.fullandroid.di

import com.hive.fullandroid.repository.user.SharedPreferencesCustom
import com.hive.fullandroid.repository.user.SharedPreferencesCustomImpl
import com.hive.fullandroid.repository.remote.api.UserRepository
import com.hive.fullandroid.repository.remote.api.UserRepositoryImpl
import com.hive.fullandroid.ui.user.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UserViewModel(get(), get()) }
}

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl() }
}

val sharedPreferenceModule = module {
    single<SharedPreferencesCustom> { SharedPreferencesCustomImpl() }
}

