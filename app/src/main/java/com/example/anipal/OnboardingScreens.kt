package com.example.anipal


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.View.INVISIBLE
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.anipal.databinding.ActivityOnboarding1Binding

class OnboardingScreens: AppCompatActivity() {


    private lateinit var bind:ActivityOnboarding1Binding
    private var currentStep = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bind = ActivityOnboarding1Binding.inflate(layoutInflater)
        setContentView(bind.root)

        //Animations

        val nextBtn = AnimationUtils.loadAnimation(this, R.anim.btn_fade_in)

        Handler(Looper.getMainLooper()).postDelayed({
            bind.nextBtn.visibility = View.VISIBLE
            bind.nextBtn.startAnimation(nextBtn)
        }, 2000)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, OnBoarding1())
            .commit()


        bind.nextBtn.setOnClickListener {
            when (currentStep) {
                1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, OnBoarding2())
                        .addToBackStack(null)
                        .commit()
                    currentStep++
                }
                2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, OnBoarding3())
                        .addToBackStack(null)
                        .commit()
                    currentStep++
                }
                3->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, OnBoarding4())
                        .addToBackStack(null)
                        .commit()
                    bind.nextBtn.visibility = INVISIBLE
                    currentStep++
                }

            }

        }

    }

}