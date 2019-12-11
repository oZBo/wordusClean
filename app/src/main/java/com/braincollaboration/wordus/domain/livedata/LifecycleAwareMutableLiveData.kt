package com.braincollaboration.wordus.domain.livedata

import androidx.lifecycle.MutableLiveData
import com.braincollaboration.wordus.presentation.base.functional.ObservableBlockingQueue

class LifecycleAwareMutableLiveData<T>(isBlocked: Boolean = true) : MutableLiveData<T>() {

    private val valuesQueue by lazy { ObservableBlockingQueue<T?>(isBlocked) }

    init {
        valuesQueue.observe { super.setValue(valuesQueue.shift()) }
    }

    override fun setValue(value: T?) {
        valuesQueue.push(value)
    }

    override fun onActive() = with(valuesQueue) {
        unblock()
        repeat(size) { super.setValue(shift()) }
    }

    override fun onInactive() = valuesQueue.block()
}
