package com.example.anipal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.anipal.databinding.ActivityForgotPasswordBinding

class ForgotPassword: AppCompatActivity() {

    private lateinit var bind: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}