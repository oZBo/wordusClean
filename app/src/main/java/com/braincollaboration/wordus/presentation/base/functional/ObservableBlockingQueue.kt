package com.braincollaboration.wordus.presentation.base.functional

open class ObservableBlockingQueue<T>(var isBlocked: Boolean) : LinkedQueue<T>() {

    private var onPush: (T) -> Unit = {}

    override fun push(item: T) {
        queue.offer(item)
        onPush(item)
    }

    override fun shift(): T? = if(isBlocked) null else queue.poll()

    fun observe(onPush: (T) -> Unit) {
        this.onPush = onPush
    }

    fun dispose() {
        this.onPush = {}
    }

    fun block() {
        isBlocked = true
    }

    fun unblock() {
        isBlocked = false
    }
}