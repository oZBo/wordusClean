package com.braincollaboration.wordus.presentation.base.functional

import java.util.*

open class LinkedQueue<T> : Queue<T> {
    protected val queue: java.util.Queue<T> by lazy { LinkedList<T>() }

    override val size: Int get() = queue.size

    override fun push(item: T) {
        queue.offer(item)
    }

    override fun shift(): T? = queue.poll()
}