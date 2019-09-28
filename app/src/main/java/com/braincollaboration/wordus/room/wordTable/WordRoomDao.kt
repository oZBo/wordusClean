package com.braincollaboration.wordus.room.wordTable

import androidx.lifecycle.LiveData
import androidx.room.*
import com.braincollaboration.wordus.room.converters.WordStatusEnum
import java.util.*

@Dao
interface WordRoomDao {

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME}")
    suspend fun getAllWords(): LiveData<MutableList<WordRoomModel>>

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} " +
            "WHERE ${WordRoomModel.COLUMN_WORD} LIKE '%' || :argLetter || '%' " +
            "OR ${WordRoomModel.COLUMN_DESCRIPTION} LIKE '%' || :argLetter || '%'")
    suspend fun getWordByLetter(argLetter: String): LiveData<MutableList<WordRoomModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(vararg wordModels: WordRoomModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(words: WordRoomModel)

    @Update
    suspend fun updateWord(wordModel: WordRoomModel)

    @Delete
    suspend fun deleteWord(wordModel: WordRoomModel)

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} WHERE ${WordRoomModel.COLUMN_ID} LIKE :id")
    suspend fun getWordById(id: Int): WordRoomModel

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} WHERE ${WordRoomModel.COLUMN_WORD} LIKE :word")
    suspend fun getWordByName(word: String): LiveData<MutableList<WordRoomModel>>

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} WHERE ${WordRoomModel.COLUMN_DESCRIPTION} LIKE :wordDescription")
    suspend fun getWordByDescription(wordDescription: String): LiveData<MutableList<WordRoomModel>>

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} WHERE ${WordRoomModel.COLUMN_CREATED_TIME} LIKE :wordCreatedTime")
    suspend fun getWordByCreatedTime(wordCreatedTime: Date): WordRoomModel

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} WHERE ${WordRoomModel.COLUMN_TASK_STATUS} LIKE :wordStatusEnum")
    suspend fun getWordByStatus(wordStatusEnum: WordStatusEnum): LiveData<MutableList<WordRoomModel>>

}