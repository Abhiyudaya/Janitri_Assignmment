package com.example.janitri_assignmment.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context

@Database(
    entities = [VitalLog::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class VitalLogDatabase : RoomDatabase() {
    abstract fun vitalLogDao(): VitalLogDao

    companion object {
        @Volatile
        private var INSTANCE: VitalLogDatabase? = null

        fun getDatabase(context: Context): VitalLogDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VitalLogDatabase::class.java,
                    "vital_log_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}