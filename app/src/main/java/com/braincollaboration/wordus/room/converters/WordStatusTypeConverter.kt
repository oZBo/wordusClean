package com.braincollaboration.wordus.room.converters

import androidx.room.TypeConverter

class WordStatusTypeConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun wordStatusEnumToOrdinal(enum: WordStatusEnum): Int {

            return enum.ordinal
        }

        @TypeConverter
        @JvmStatic
        fun ordinalToWordStatusEnum(enumOrdinal: Int): WordStatusEnum? {

            return WordStatusEnum.values()[enumOrdinal]
        }

    }

}

enum class WordStatusEnum {
    //do not change the order
    SEARCHING_MEANING,
    NO_MEANING,
    MEANING_NOT_SHOWN,
    MEANING_SHOWN
}