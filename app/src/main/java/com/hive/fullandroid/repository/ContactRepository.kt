package com.hive.fullandroid.repository

import com.hive.fullandroid.App
import com.hive.fullandroid.repository.local.DataBaseHelper
import com.hive.fullandroid.repository.local.entity.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ContactRepository {

    fun saveContact(contact: Contact,
                    callbackSuccess: () -> Unit,
                    callbackFailure: (Exception) -> Unit){

        val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

        scope.launch {
            try {
                val instance = DataBaseHelper.getInstance(App.appCtx())
                instance?.getContactDao()?.add(contact)
                callbackSuccess()
            } catch (e : Exception){
                callbackFailure(e)
            }
        }




    }
}