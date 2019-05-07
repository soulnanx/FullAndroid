package com.hive.fullandroid.ui.contact

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.hive.fullandroid.R
import com.hive.fullandroid.databinding.ActivityContactBinding
import com.hive.fullandroid.repository.local.entity.Contact

class ContactActivity : AppCompatActivity(), ContactNavigation {
    private val viewModel by lazy {
        ViewModelProviders.of(this@ContactActivity).get(ContactViewModel::class.java)
    }

    private val binding : ActivityContactBinding by  lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_contact) as ActivityContactBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        viewModel.nav = this
        init()
    }

    private fun init() {
        setEvents()
    }

    private fun setEvents() {
        binding.btnCreate.setOnClickListener {
            val contactToSave = Contact(
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString())

            viewModel.saveContact(contactToSave)
        }

        binding.btnLoad.setOnClickListener {
            viewModel.getContacts()
        }
    }

    private fun setList(contacts: List<Contact>) {
        with(binding.recyclerContacts){
            adapter = ContactAdapter(context, contacts)
        }
    }

    override fun save(isSuccess: Boolean, e: Exception?) {
        if (isSuccess){
            Toast.makeText(this@ContactActivity, "saved!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@ContactActivity, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun all(isSuccess: Boolean, contacts: List<Contact>, e: Exception?) {
        if (isSuccess){
            setList(contacts)
        } else {
            Toast.makeText(this@ContactActivity, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }


}