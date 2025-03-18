package com.example.anipal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.anipal.databinding.ActivitySignupBinding

class SignUp: AppCompatActivity() {


    private lateinit var bind: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bind =ActivitySignupBinding.inflate(layoutInflater)
        setContentView(bind.root)


        bind.signup.setOnClickListener{
            val intent = Intent(this,HomeView::class.java)
            startActivity(intent)
            finish()
        }
        bind.loginLink.setOnClickListener{
            val intent = Intent(this,SignIn::class.java)
            startActivity(intent)
            finish()
        }
    }
}