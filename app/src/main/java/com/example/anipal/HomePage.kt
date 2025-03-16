package com.example.anipal


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.anipal.databinding.ActivityHomepageBinding

class HomePage: AppCompatActivity() {

    private lateinit var bind: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bind = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}