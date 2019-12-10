package com.braincollaboration.wordus.base.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.braincollaboration.wordus.domain.exception.Failure
import kotlinx.coroutines.Job

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
        liveData.observe(this, Observer(body))

fun <L : LiveData<Failure<*>>> LifecycleOwner.failure(liveData: L, body: (Failure<*>?) -> Unit) =
        liveData.observe(this, Observer(body))

fun <L : LiveData<ArrayList<Job>>> LifecycleOwner.loader(liveData: L, body: (ArrayList<Job>?) -> Unit) =
        liveData.observe(this, Observer(body))