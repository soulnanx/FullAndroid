package com.hive.fullandroid

import android.app.Application
import com.facebook.stetho.Stetho
import com.hive.fullandroid.di.repositoryModule
import com.hive.fullandroid.di.sharedPreferenceModule
import com.hive.fullandroid.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

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

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(listOf(viewModelModule,
                repositoryModule,
                sharedPreferenceModule)
            )
        }
    }
}