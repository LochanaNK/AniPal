package com.example.anipal

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val logo: ImageView = findViewById(R.id.Logo)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        logo.startAnimation(fadeIn)

        val title: TextView = findViewById(R.id.Title)
        val fadeInText = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        Handler(Looper.getMainLooper()).postDelayed({
            title.visibility= View.VISIBLE
            title.startAnimation(fadeInText)
        }, 1000)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent=Intent(this,OnboardingScreens::class.java)
            startActivity(intent)

        },3000)
    }
}