package com.braincollaboration.wordus.data.room.converters

import androidx.room.TypeConverter

object WordStatusTypeConverter {

    @TypeConverter
    @JvmStatic
    fun wordStatusEnumToOrdinal(enum: WordStatusEnum): Int = enum.ordinal

    @TypeConverter
    @JvmStatic
    fun ordinalToWordStatusEnum(enumOrdinal: Int): WordStatusEnum? =
        WordStatusEnum.values()[enumOrdinal]

}

enum class WordStatusEnum {
    //do not change the order
    SEARCHING_MEANING,
    NO_MEANING,
    MEANING_NOT_SHOWN,
    MEANING_SHOWN
}