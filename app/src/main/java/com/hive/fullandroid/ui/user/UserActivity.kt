package com.hive.fullandroid.ui.user

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hive.fullandroid.R
import com.hive.fullandroid.databinding.ActivityUserBinding
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel

class UserActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()

    private val binding by lazy{
        DataBindingUtil.setContentView(this@UserActivity, R.layout.activity_user) as ActivityUserBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        binding.viewModel = viewModel

        init()
    }

    private fun init() {
        viewModel.getUser()
    }


}