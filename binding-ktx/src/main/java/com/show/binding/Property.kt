package com.show.binding

import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class BindingProperty<T : ViewBinding> : ReadWriteProperty<Any, T>,
    LifecycleObserver {

    private var binding: T? = null
    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        binding = value
        if(thisRef is LifecycleOwner){
            if(binding is ViewDataBinding){
                (binding as ViewDataBinding).lifecycleOwner = thisRef
            }
            thisRef.lifecycle.removeObserver(this)
            thisRef.lifecycle.addObserver(this)
        }
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): T = binding
        ?: throw IllegalAccessException("Do not try to call the Binding outside the Activity view lifecycle")

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        binding = null
    }
}
