package com.show.androidktx

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import com.show.view.rotateX

import com.show.view.translateToX
import com.show.view.translateToXY
import com.show.view.translateToY
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

class MainActivity : AppCompatActivity() {
    @ExperimentalTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        tv1.post {



        }



    }
}