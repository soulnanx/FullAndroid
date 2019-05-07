package com.hive.fullandroid.repository.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact (@ColumnInfo(name = "contact_name") val name: String,
               @ColumnInfo(name = "contact_email") val email: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    var id: Int = 0
}