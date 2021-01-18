package com.show.androidktx

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.show.androidktx.databinding.ActivityMainBinding
import com.show.binding.BindingProperty
import com.show.binding.binding

class MainActivity : AppCompatActivity() {

    var binding by BindingProperty<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = binding(this,R.layout.activity_main)

        binding.tv1.setOnClickListener {
            Toast.makeText(this,"123123121",Toast.LENGTH_LONG).show()
        }


    }
}