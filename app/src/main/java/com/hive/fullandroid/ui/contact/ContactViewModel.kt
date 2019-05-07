package com.hive.fullandroid.ui.contact

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hive.fullandroid.repository.ContactRepository
import com.hive.fullandroid.repository.local.entity.Contact

class ContactViewModel() : ViewModel(){

    lateinit var nav : ContactNavigation

    fun saveContact(contact: Contact){
        ContactRepository().saveContact(
            contact,
            nav::save
        )
    }

    fun getContacts(){
        ContactRepository().getContacts(nav::all)
    }




}
