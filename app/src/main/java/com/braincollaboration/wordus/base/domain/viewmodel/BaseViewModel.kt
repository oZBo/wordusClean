package com.braincollaboration.wordus.base.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.braincollaboration.wordus.base.domain.event.Event
import com.braincollaboration.wordus.base.domain.exception.Failure
import com.braincollaboration.wordus.base.domain.livedata.LifecycleAwareMutableLiveData
import com.braincollaboration.wordus.base.functional.Either
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData<ArrayList<Job>>()
    private val _failure = LifecycleAwareMutableLiveData<Failure<*>>()
    private val _event = LifecycleAwareMutableLiveData<Event<*>>()

    val failure: LiveData<Failure<*>> = _failure
    val loading: LiveData<ArrayList<Job>> = _loading
    val event: LiveData<Event<*>> = _event

    fun postFailure(failure: Failure<*>) {
        _failure.value = failure
    }

    fun postEvent(event: Event<*>) {
        _event.value = event
    }

    fun loading(useCase: Job) {
        addLoading(useCase)
        useCase.invokeOnCompletion { viewModelScope.launch { removeLoading(useCase) } }
    }

    protected fun <R> Either<Failure<*>, R>.handle(handler: (R) -> Unit = {}): Any =
            either(::postFailure, handler)

    protected inline fun <reified R : Any> Either<Failure<*>, R>.getOrNull(): R? =
            either(::postFailure) { it } as? R

    protected inline fun <reified R : Any> Either<Failure<*>, R>.get(default: R): R =
            getOrNull() ?: default

    private fun addLoading(loading: Job) {
        _loading.value = (_loading.value ?: ArrayList()).apply { add(loading) }
    }

    private fun removeLoading(loading: Job) {
        _loading.value = (_loading.value ?: ArrayList()).apply { remove(loading) }
    }
}