package com.hive.fullandroid.repository.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hive.fullandroid.repository.local.dao.ContactDao
import com.hive.fullandroid.repository.local.entity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class DataBaseHelper : RoomDatabase(){

    companion object {

        private const val DB_NAME = "app"
        @Volatile
        private var instance: DataBaseHelper? = null

        @Synchronized
        internal fun getInstance(context: Context): DataBaseHelper? {
            if (instance == null) {
                instance =
                    create(context)
            }
            return instance
        }

        private fun create(context: Context): DataBaseHelper {
            return Room.databaseBuilder(context, DataBaseHelper::class.java,
                DB_NAME
            )
                .build()
        }

    }

     abstract fun getContactDao() : ContactDao
}