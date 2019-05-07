package com.hive.fullandroid.repository

import com.hive.fullandroid.App
import com.hive.fullandroid.repository.local.DataBaseHelper
import com.hive.fullandroid.repository.local.entity.Contact
import kotlinx.coroutines.*

class ContactRepository {

    private val db = DataBaseHelper.getInstance(App.appCtx())

    fun saveContact(contact: Contact,
                            callback: (Boolean, Exception?) -> Unit){

        val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

        scope.launch {
            try {
                withContext(Dispatchers.Default){db.getContactDao().add(contact)}
                callback(true, null)
            } catch (e : Exception){
                callback(false, e)
            }
        }
    }

//    fun getAllContacts() : LiveData<List<Contact>>{
//        return db.getContactDao().getAll()
//    }
//
//    fun getContacts() : LiveData<List<Contact>>{
//        return db.getContactDao().getAll()
//    }

    fun getContacts(callback: (Boolean, List<Contact>, Exception?) -> Unit){
        val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

        scope.launch {
            try {
                val contacts = withContext(Dispatchers.Default){db.getContactDao().getAll()}
                callback(true, contacts, null)
            } catch (e : Exception){
                callback(false, emptyList(), e)
            }
        }

    }
}