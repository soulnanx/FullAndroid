package com.hive.fullandroid.repository.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact (@PrimaryKey(autoGenerate = true)
               @ColumnInfo(name = "contact_id")val id: Int = 0,
               @ColumnInfo(name = "contact_name") val name: String,
               @ColumnInfo(name = "contact_email") val email: String) {
}