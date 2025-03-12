package com.example.anipal

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class OnboardingScreens: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding1)

                            //Animations

        val description1: TextView = findViewById(R.id.description1)
        val btn: Button = findViewById(R.id.next_btn1)
        val fadeInText = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val nextBtn = AnimationUtils.loadAnimation(this,R.anim.btn_fade_in)

        Handler(Looper.getMainLooper()).postDelayed({
            description1.visibility= View.VISIBLE
            description1.startAnimation(fadeInText)
        }, 1000)
        
        Handler(Looper.getMainLooper()).postDelayed({
            btn.visibility= View.VISIBLE
            btn.startAnimation(nextBtn)
        }, 2000)
    }

}