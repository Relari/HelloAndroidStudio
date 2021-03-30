package com.pe.relari.helloandroidstudio.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pe.relari.helloandroidstudio.business.dao.EmployeeDao
import com.pe.relari.helloandroidstudio.business.model.entity.EmployeeEntity

@Database(
    entities = [EmployeeEntity::class],
    version = 1
)
abstract class DatabaseConfig : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {

        @Volatile
        private var INSTANCE : DatabaseConfig? = null

        fun getDataBase(context: Context) : DatabaseConfig {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseConfig::class.java,
                    "DEMO"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}