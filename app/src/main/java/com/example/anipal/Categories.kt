package com.example.anipal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.anipal.databinding.ActivityCategoriesBinding

class Categories : AppCompatActivity() {

    private lateinit var bind: ActivityCategoriesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bind = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(bind.root)

    }
}