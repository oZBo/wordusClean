package com.braincollaboration.wordus.base.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LiveData
import com.braincollaboration.wordus.domain.exception.Failure
import kotlinx.coroutines.Job

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

//viewLifecycleOwner should be use to avoid leaking LiveData observers. Issue: https://github.com/googlesamples/android-architecture-components/issues/47
fun <T : Any, L : LiveData<T>> Fragment.observe(liveData: L, body: (T?) -> Unit) =
    viewLifecycleOwner.observe(liveData, body)

fun <L : LiveData<Failure<*>>> Fragment.failure(liveData: L, body: (Failure<*>?) -> Unit) =
    viewLifecycleOwner.failure(liveData, body)

fun <L : LiveData<ArrayList<Job>>> Fragment.loader(liveData: L, body: (ArrayList<Job>?) -> Unit) =
    viewLifecycleOwner.loader(liveData, body)