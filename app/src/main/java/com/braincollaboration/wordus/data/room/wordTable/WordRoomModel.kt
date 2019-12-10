package com.braincollaboration.wordus.data.room.wordTable

import android.os.Parcelable
import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.braincollaboration.wordus.data.room.converters.WordStatusEnum
import com.braincollaboration.wordus.data.room.wordTable.WordRoomModel.Companion.TABLE_NAME
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = TABLE_NAME)
data class WordRoomModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long? = null,
    @ColumnInfo(name = COLUMN_WORD)
    var word: String,
    @ColumnInfo(name = COLUMN_MEANING)
    var description: String?,
    @ColumnInfo(name = COLUMN_CREATED_TIME)
    val createdTime: Date = Date(),
    @ColumnInfo(name = COLUMN_STATUS)
    var wordStatusEnum: WordStatusEnum = WordStatusEnum.SEARCHING_MEANING
) : Parcelable, Categorizable {

    override val category: String
        get() = word[0].toString()
    override val name: String
        get() = word

    companion object {

        const val TABLE_NAME = "word_table"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_WORD = "word"
        const val COLUMN_MEANING = "meaning"
        const val COLUMN_CREATED_TIME = "created_time"
        const val COLUMN_STATUS = "status"

    }
}

fun String.toWordPresentation() =
    WordRoomModel(word = "", description = "") /*TODO convert from server entity to app entity*/