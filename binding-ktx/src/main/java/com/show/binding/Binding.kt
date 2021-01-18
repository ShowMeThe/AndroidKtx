package com.show.binding

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding


inline fun <reified V : ViewBinding> binding(activity: ComponentActivity, @LayoutRes layoutId: Int): V {
    val clazz = V::class.java
    return if (ViewBinding::class.java.isAssignableFrom(clazz)
        && !ViewDataBinding::class.java.isAssignableFrom(clazz)
    ) {
        /**
         * For ViewBinding Only
         */
        val method = clazz.getDeclaredMethod("inflate", LayoutInflater::class.java)
        val binding = method.invoke(clazz, activity.layoutInflater) as V
        activity.setContentView(binding.root)
        binding
    } else {
        /**
         * For ViewDataBinding Only
         */
        DataBindingUtil.setContentView<ViewDataBinding>(activity, layoutId) as V
    }
}

inline fun <reified V : ViewBinding> binding(view: View): V? {
    val clazz = V::class.java
    return if (ViewBinding::class.java.isAssignableFrom(clazz)
        && !ViewDataBinding::class.java.isAssignableFrom(clazz)
    ) {
        /**
         * For ViewBinding Only
         */
        val method = clazz.getDeclaredMethod("bind", View::class.java)
        val binding = method.invoke(clazz, view) as V?
        binding
    } else {
        /**
         * For ViewDataBinding Only
         */
        DataBindingUtil.bind<ViewDataBinding>(view) as V?
    }
}
