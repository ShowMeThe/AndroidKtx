package com.show.androidktx

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.show.androidktx.databinding.ActivityMainBinding
import com.show.binding.BindingProperty
import com.show.binding.binding
import com.show.span.foregroundColor
import com.show.span.span

class MainActivity : AppCompatActivity() {

    val binding by lazy { binding<ActivityMainBinding>(this,R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val text = "测试内容演示Spannable"


        binding.apply {

            tv1.text = text.span.apply {
                foregroundColor(Color.RED,0..7)

            }




        }


    }
}