package com.braincollaboration.wordus.room.wordTable

import android.os.Parcelable
import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.braincollaboration.wordus.room.converters.WordStatusEnum
import com.braincollaboration.wordus.room.wordTable.WordRoomModel.Companion.TABLE_NAME
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = TABLE_NAME)
data class WordRoomModel(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = COLUMN_ID)
        var id: Long? = null,
        @ColumnInfo(name = COLUMN_TITLE)
        var title: String?,
        @ColumnInfo(name = COLUMN_DESCRIPTION)
        var description: String,
        @ColumnInfo(name = COLUMN_CREATED_TIME)
        val createdTime: Date,
        @ColumnInfo(name = COLUMN_TASK_STATUS)
        var taskStatusEnum: WordStatusEnum
) : Parcelable {

    companion object {

        const val TABLE_NAME = "words"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_TITLE = "title"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_CREATED_TIME = "created_time"
        const val COLUMN_TASK_STATUS = "word_status"

    }
}