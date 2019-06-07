package com.hive.fullandroid.repository.user

import android.content.Context
import com.hive.fullandroid.App
import com.hive.fullandroid.BuildConfig

class SharedPreferencesCustomImpl : SharedPreferencesCustom{

    private val MY_KEY = "KEY"
    private val SHARED_PREFERENCES = BuildConfig.APPLICATION_ID
    private val sharedPreferences by lazy {
        App.appCtx()
            .getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

    private val editor by lazy {
        sharedPreferences.edit()
    }

    override fun save(key: String, value: String) {
        editor.putString(key, value).commit()
    }

    override fun delete(key: String) {
        editor.remove(key).commit()
    }

    override fun load(key: String): String {
        return sharedPreferences.getString(key, "")
    }

}