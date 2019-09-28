package com.braincollaboration.wordus.feature.home.api

import com.braincollaboration.wordus.base.api.Repository
import com.braincollaboration.wordus.base.domain.exception.Failure
import com.braincollaboration.wordus.base.functional.Either
import com.braincollaboration.wordus.feature.home.view.WordPresentation
import com.braincollaboration.wordus.feature.home.view.toWordPresentation

interface WordRepository : Repository {

    fun findWordMeaning(word: String): Either<Failure<*>, WordPresentation>

    class Network(private val wordService: WordService) : Repository.BaseNetwork(), WordRepository {

        override fun findWordMeaning(word: String) = request(
                wordService.getWordMeaning(word),
                { it.toWordPresentation() },
                "")

    }

}