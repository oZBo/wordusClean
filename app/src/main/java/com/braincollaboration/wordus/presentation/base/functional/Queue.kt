package com.braincollaboration.wordus.presentation.base.functional

interface Queue<T> {
    val size: Int

    fun push(item: T)
    fun shift(): T?
}