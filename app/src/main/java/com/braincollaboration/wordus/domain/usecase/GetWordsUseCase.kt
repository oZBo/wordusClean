package com.braincollaboration.wordus.domain.usecase

import com.braincollaboration.wordus.domain.exception.Failure
import com.braincollaboration.wordus.presentation.base.functional.Either
import com.braincollaboration.wordus.domain.usecase.base.UseCase
import com.braincollaboration.wordus.data.repository.WordRepository
import com.braincollaboration.wordus.data.room.wordTable.WordRoomModel

class GetWordsUseCase(
    private val wordsRepository: WordRepository
) : UseCase<List<WordRoomModel>, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure<*>, List<WordRoomModel>> {
//        return wordsRepository.findWordMeaning()
        TODO()
    }

}