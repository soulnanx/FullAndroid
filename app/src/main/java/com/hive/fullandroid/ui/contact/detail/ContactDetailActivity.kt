package com.hive.fullandroid.ui.contact.detail

import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hive.fullandroid.R
import com.hive.fullandroid.databinding.ActivityContactDetailBinding

class ContactDetailActivity : AppCompatActivity() {


    val binding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_contact_detail) as ActivityContactDetailBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        handleIntent()
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
            showContact(it.lastPathSegment)
        }
    }

    private fun showContact(id: String){
        binding.txtContactId.text = id
    }
}