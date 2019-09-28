package com.braincollaboration.wordus.base.interactor

import com.braincollaboration.wordus.base.domain.exception.Failure
import com.braincollaboration.wordus.base.functional.Either
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.CoroutineContext

abstract class UseCase<out Type, in Params>(private val context: CoroutineContext = Dispatchers.IO) where Type : Any {

    private val mutex by lazy { Mutex() }
    private var _parentScope: CoroutineScope? = null
    private val parentScope: CoroutineScope get() = _parentScope ?: CoroutineScope(SupervisorJob())

    abstract suspend fun run(params: Params): Either<Failure<*>, Type>

    @Deprecated("Use suspendable invoke() directly in the coroutine scope instead")
    operator fun invoke(params: Params, onResult: (Either<Failure<*>, Type>) -> Unit): Job =
            parentScope.launch(context) {
                mutex.withLock {
                    val job = async { run(params) }
                    withContext(Dispatchers.Main.immediate) { onResult(job.await()) }
                }
            }

    suspend operator fun invoke(params: Params): Either<Failure<*>, Type> =
            withContext(context) { mutex.withLock { run(params) } }

    /**
     *  Sets a parent coroutine scope to control the UseCase cancellation.
     */
    fun setParentScope(scope: CoroutineScope) {
        _parentScope = scope
    }

    object None

}