package com.example.appdjango

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var rvFood:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvFood = findViewById(R.id.rv_food)

        rvFood.layoutManager = LinearLayoutManager(this)


        val repository = FootRepository(FootApi())

        GlobalScope.launch(Dispatchers.Main){
            val menu = repository.getMenu()
            val adapter = FoodAdapter(menu)
            rvFood.adapter = adapter
        }
    }
}