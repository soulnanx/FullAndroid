package com.hive.fullandroid.ui.contact

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hive.fullandroid.repository.ContactRepository
import com.hive.fullandroid.repository.local.entity.Contact

class ContactViewModel() : ViewModel(){

    lateinit var nav : ContactNavigation

    var contacts = MutableLiveData<List<Contact>>()
    var contactsError = MutableLiveData<String>()

    fun saveContact(contact: Contact){
        ContactRepository().saveContact(
            contact,
            nav::save
        )
    }

    fun getContacts(){
        ContactRepository().getContacts { isSuccess, list, e ->
            run {
                if (isSuccess) {
                    contacts.value = list
                } else {
                    contactsError.value = e.toString()
                }
            }
        }
    }




}
