package com.hive.fullandroid.ui.contact

import com.hive.fullandroid.repository.local.entity.Contact


interface ContactNavigation {
    fun save(isSuccess : Boolean, e : Exception?)
    fun all(isSuccess : Boolean, contacts : List<Contact>, e : Exception?)
}
