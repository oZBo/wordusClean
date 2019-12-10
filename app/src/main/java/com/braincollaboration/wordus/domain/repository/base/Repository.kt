package com.braincollaboration.wordus.domain.repository.base

import com.braincollaboration.wordus.domain.exception.Failure
import com.braincollaboration.wordus.base.functional.Either
import com.braincollaboration.wordus.base.functional.Either.Left
import com.braincollaboration.wordus.base.functional.Either.Right
import com.braincollaboration.wordus.domain.usecase.base.UseCase.None
import retrofit2.Call

interface Repository {

    abstract class BaseNetwork {

        protected fun request(call: Call<Any>): Either<Failure<*>, None> = request(call, { None }, None)

        protected fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure<*>, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Right(transform((response.body() ?: default)))
                    false -> Left(Failure.serverError(response))
                }
            } catch (e: Throwable) {
                Left(Failure.UnexpectedNetworkError())
            }
        }

    }

}