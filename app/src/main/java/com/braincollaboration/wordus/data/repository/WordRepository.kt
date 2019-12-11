package com.braincollaboration.wordus.data.repository

import com.braincollaboration.wordus.presentation.base.functional.Either
import com.braincollaboration.wordus.data.room.wordTable.WordRoomModel
import com.braincollaboration.wordus.data.room.wordTable.toWordPresentation
import com.braincollaboration.wordus.domain.exception.Failure
import com.braincollaboration.wordus.domain.repository.base.Repository
import com.braincollaboration.wordus.data.network.api.WordService

interface WordRepository : Repository {

    fun findWordMeaning(word: String): Either<Failure<*>, WordRoomModel>

    class Network(private val wordService: WordService) : Repository.BaseNetwork(),
        WordRepository {

        override fun findWordMeaning(word: String) = request(
            wordService.getWordMeaning(word),
            { it.toWordPresentation() },
            ""
        )

    }

}