package com.braincollaboration.wordus.room.converters

import androidx.room.TypeConverter
import java.util.*

class DateTypeConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromTimestampToDate(value: Long?): Date? {

            return if (value == null) null else Date(value)
        }

        @TypeConverter
        @JvmStatic
        fun dateToTimestamp(date: Date?): Long? {

            return date?.time
        }

    }

}