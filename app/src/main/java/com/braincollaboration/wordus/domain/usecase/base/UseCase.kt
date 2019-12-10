package com.braincollaboration.wordus.domain.usecase.base

import com.braincollaboration.wordus.domain.exception.Failure
import com.braincollaboration.wordus.base.functional.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class UseCase<out Type, in Params>(
    private val context: CoroutineContext = Dispatchers.IO
) where Type : Any {

    private val mutex by lazy { Mutex() }

    protected abstract suspend fun run(params: Params): Either<Failure<*>, Type>

    suspend operator fun invoke(params: Params): Either<Failure<*>, Type> =
        withContext(context) {
            run(params)
        }

    object None

}