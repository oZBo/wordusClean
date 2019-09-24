package com.braincollaboration.wordus.feature.home.interactor

import com.braincollaboration.wordus.base.domain.exception.Failure
import com.braincollaboration.wordus.base.functional.Either
import com.braincollaboration.wordus.base.interactor.UseCase
import com.braincollaboration.wordus.feature.home.api.WordRepository
import com.braincollaboration.wordus.feature.home.view.WordPresentation


class GetWords(private val wordsRepository: WordRepository)
    : UseCase<List<WordPresentation>, UseCase.None>(){

    override suspend fun run(params: None): Either<Failure<*>, List<WordPresentation>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}