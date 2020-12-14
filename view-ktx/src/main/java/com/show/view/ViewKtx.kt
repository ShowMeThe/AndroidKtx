package com.show.view

import android.view.View
import android.view.View.*
import android.view.ViewTreeObserver
import com.google.android.material.tabs.TabLayout


inline val View.visible get() = apply {  visibility = VISIBLE }

inline val View.invisible get() = apply {  visibility = INVISIBLE }

inline val View.gone get() = apply {  visibility = GONE }

inline fun View.setOnSingleClickListener(crossinline onSingleClick : (it: View)->Unit){
    var lastClickTime = 0L
    val lastLongTime = 1500L

    setOnClickListener {
        val time = System.currentTimeMillis()
        if(time - lastClickTime > lastLongTime){
            onSingleClick.invoke(it)
            lastClickTime = time
        }
    }
}

inline fun <T : View> T.onGlobalLayout(crossinline  onLayout: T.()->Unit){
    if (viewTreeObserver.isAlive) {
        viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                onLayout()
                viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
    }
}

inline fun <T : View> T.onPreDrawLayout(crossinline  onLayout: T.()->Unit){
    if (viewTreeObserver.isAlive) {
        viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {

            override fun onPreDraw(): Boolean {
                onLayout()
                viewTreeObserver.removeOnPreDrawListener(this)
                return false
            }
        })
    }
}

inline fun TabLayout.onTabSelected(tabSelect: TabSelect.() -> Unit) {
    tabSelect.invoke(TabSelect(this))
}

class TabSelect(tab: TabLayout) {
    private var tabReselected: ((tab: TabLayout.Tab) -> Unit)? = null
    private var tabUnselected: ((tab: TabLayout.Tab) -> Unit)? = null
    private var tabSelected: ((tab: TabLayout.Tab) -> Unit)? = null

    fun onTabReselected(tabReselected: (TabLayout.Tab.() -> Unit)) {
        this.tabReselected = tabReselected
    }

    fun onTabUnselected(tabUnselected: (TabLayout.Tab.() -> Unit)) {
        this.tabUnselected = tabUnselected
    }

    fun onTabSelected(tabSelected: (TabLayout.Tab.() -> Unit)) {
        this.tabSelected = tabSelected
    }

    init {
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.apply { tabReselected?.invoke(tab) }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.apply { tabUnselected?.invoke(tab) }

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.apply { tabSelected?.invoke(tab) }
            }

        })
    }

}