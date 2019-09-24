package com.braincollaboration.wordus.base.functional

interface Queue<T> {
    val size: Int

    fun push(item: T)
    fun shift(): T?
}