package com.hive.fullandroid.ui.contact

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.hive.fullandroid.R
import com.hive.fullandroid.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this@ContactActivity).get(ContactViewModel::class.java)
    }

    private val binding : ActivityContactBinding by  lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_contact) as ActivityContactBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        handleIntent()
        init()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent()
    }

    private fun handleIntent() {
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data

        appLinkData?.let {
            var user = it.lastPathSegment
            Toast.makeText(this@ContactActivity, user.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun init() {
        setEvents()
    }

    private fun setObservable() {
        viewModel.name.observe(
            this,
            Observer {  })
    }

    private fun setEvents() {
        binding.btnCreate.setOnClickListener {
            Toast.makeText(this@ContactActivity, binding.edtName.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}