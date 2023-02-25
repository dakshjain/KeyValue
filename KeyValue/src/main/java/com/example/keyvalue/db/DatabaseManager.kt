package com.example.keyvalue.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Database::class], version = 1
)
abstract class DatabaseManager: RoomDatabase() {
    abstract fun dataStoreDto(): DataStoreDao

    companion object {
        @Volatile private var instance: DatabaseManager? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            DatabaseManager::class.java, "keyvalue.db")
            .build()
    }
}