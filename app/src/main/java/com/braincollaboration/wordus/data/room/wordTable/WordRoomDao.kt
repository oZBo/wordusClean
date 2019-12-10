package com.braincollaboration.wordus.data.room.wordTable

import androidx.lifecycle.LiveData
import androidx.room.*
import com.braincollaboration.wordus.data.room.converters.WordStatusEnum
import java.util.*

@Dao
interface WordRoomDao {

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME}")
    fun getAllWords(): LiveData<List<WordRoomModel>>

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} " +
            "WHERE ${WordRoomModel.COLUMN_WORD} LIKE '%' || :argLetter || '%' " +
            "OR ${WordRoomModel.COLUMN_MEANING} LIKE '%' || :argLetter || '%'")
    fun getWordByLetter(argLetter: String): LiveData<List<WordRoomModel>>

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
    fun getWordByName(word: String): LiveData<List<WordRoomModel>>

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} WHERE ${WordRoomModel.COLUMN_MEANING} LIKE :wordDescription")
    fun getWordByDescription(wordDescription: String): LiveData<List<WordRoomModel>>

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} WHERE ${WordRoomModel.COLUMN_CREATED_TIME} LIKE :wordCreatedTime")
    suspend fun getWordByCreatedTime(wordCreatedTime: Date): WordRoomModel

    @Query("SELECT * FROM ${WordRoomModel.TABLE_NAME} WHERE ${WordRoomModel.COLUMN_STATUS} LIKE :wordStatusEnum")
    fun getWordByStatus(wordStatusEnum: WordStatusEnum): LiveData<List<WordRoomModel>>

}