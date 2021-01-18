package com.show.androidktx

import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.show.androidktx.databinding.ActivityMainBinding
import com.show.binding.BindingProperty
import com.show.binding.binding
import com.show.span.*

class MainActivity : AppCompatActivity() {

    val binding by lazy { binding<ActivityMainBinding>(this,R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val text = "测试内容演示Spannable"


        binding.apply {

            tv1.movementMethod = LinkMovementMethod.getInstance()
            tv1.setHintTextColor(Color.TRANSPARENT)
            tv1.text = text.span.apply {
                foregroundColor(Color.RED,0..7)
                italic(0..2)
                backgroundColor(Color.LTGRAY,0..3)
                underline(0..2)
                strikeThrough(6..9)
                bold(2..4)
                boldItalic(6..9)
                size(25,0..1)
                sizeRelative(2f,1..2)
                val drawable = ContextCompat.getDrawable(this@MainActivity,R.mipmap.ic_launcher_round)
                drawable!!.setBounds(0,0,drawable.intrinsicHeight,drawable.intrinsicWidth)
                image(drawable,0..1)
                click(10..12){
                    Toast.makeText(this@MainActivity, text,Toast.LENGTH_LONG).show()
                }
            }

        }


    }
}