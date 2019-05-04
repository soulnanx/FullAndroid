package com.hive.fullandroid.repository

import android.arch.lifecycle.LiveData
import com.hive.fullandroid.App
import com.hive.fullandroid.repository.local.DataBaseHelper
import com.hive.fullandroid.repository.local.entity.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ContactRepository {

    private val db = DataBaseHelper.getInstance(App.appCtx())

    fun saveContact(contact: Contact,
                    callback: (Boolean, Exception?) -> Unit){

        val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

        scope.launch {
            try {
                db.getContactDao().add(contact)
                callback(true, null)
            } catch (e : Exception){
                callback(false, e)
            }
        }
    }

    fun getContacts() : LiveData<List<Contact>>{
        return db.getContactDao().getAll()
    }
}