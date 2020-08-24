package com.example.appdjango

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = FootRepository(FootApi())

        GlobalScope.launch(Dispatchers.Main){
            val menu = repository.getMenu()
            Toast.makeText(this@MainActivity, menu.toString(), Toast.LENGTH_LONG).show()
        }
    }
}