package com.braincollaboration.wordus.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.braincollaboration.wordus.BuildConfig
import com.braincollaboration.wordus.data.room.converters.DateTypeConverter
import com.braincollaboration.wordus.data.room.converters.WordStatusTypeConverter
import com.braincollaboration.wordus.data.room.wordTable.WordRoomDao
import com.braincollaboration.wordus.data.room.wordTable.WordRoomModel

@Database(entities = [WordRoomModel::class], version = 1)
@TypeConverters(DateTypeConverter::class, WordStatusTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskRoomDao(): WordRoomDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private var DB_NAME: String = "${BuildConfig.APPLICATION_ID}.database"

        fun initAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room
                            .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                            .build()
                }
            }

            return INSTANCE
        }

        fun getAppDataBase(): AppDatabase? {

            return INSTANCE
        }

        fun destroyDataBase() {

            INSTANCE = null
        }

    }
}