package com.hive.fullandroid.repository.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.hive.fullandroid.repository.local.entity.Contact

@Dao
interface ContactDao {

    @Insert
    fun add(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getAll() : LiveData<List<Contact>>

    @Update
    fun update(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}