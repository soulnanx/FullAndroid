package com.hive.fullandroid.repository.user

interface SharedPreferencesCustom {
    fun save(key: String, value: String)
    fun delete(key: String)
    fun load(key: String) : String
}