package com.hive.fullandroid

import android.app.Application
import com.facebook.stetho.Stetho

class App : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun appCtx() : App {
            return instance!!.applicationContext as App
        }

    }

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init(){
        Stetho.initializeWithDefaults(this@App)
    }
}