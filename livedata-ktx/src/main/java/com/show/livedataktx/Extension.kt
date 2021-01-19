package com.show.livedataktx

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData


fun <T> LiveData<T>.filter(predicate: (T) -> Boolean): MediatorLiveData<T> {
    val source = MediatorLiveData<T>()
    source.addSource(this) {
        if (predicate.invoke(it)) {
            source.value = it
        }
    }
    return source
}

fun <T, R> LiveData<T>.map(predicate: (T) -> R): MediatorLiveData<R> {
    val source = MediatorLiveData<R>()
    source.addSource(this) {
        source.value = predicate.invoke(it)
    }
    return source
}

fun <T> LiveData<T>.distinctUntilChanged(): MediatorLiveData<T> {
    val source = MediatorLiveData<T>()
    source.addSource(this) {
        if (it != source.value) {
            source.value = it
        }
    }
    return source
}

fun <T> LiveData<T>.distinctUntilChanged(compare: (oldData: T?, newData: T?) -> Boolean): MediatorLiveData<T> {
    val source = MediatorLiveData<T>()
    source.addSource(this) {
        if (compare.invoke(source.value,it)) {
            source.value = it
        }
    }
    return source
}

fun <T> LiveData<T>.debounce(timeout: Long): MediatorLiveData<T> {
    var lastSetTime = 0L
    val source = MediatorLiveData<T>()
    source.addSource(this) {
        if (System.currentTimeMillis() - lastSetTime > timeout) {
            source.value = it
        }
        lastSetTime = System.currentTimeMillis()
    }
    return source
}

