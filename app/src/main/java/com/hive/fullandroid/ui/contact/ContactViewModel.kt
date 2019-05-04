package com.hive.fullandroid.ui.contact

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hive.fullandroid.repository.ContactRepository
import com.hive.fullandroid.repository.local.entity.Contact

class ContactViewModel(private val nav : ContactNavigation) : ViewModel(){

    var name = MutableLiveData<String>()
    var email = MutableLiveData<String>()

    fun saveContact(contact: Contact){
        ContactRepository().saveContact(
            contact,
            nav::callback
        )
    }




}
