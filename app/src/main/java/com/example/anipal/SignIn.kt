package com.example.anipal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.anipal.databinding.ActivitySigninBinding


class SignIn:AppCompatActivity() {

    private lateinit var bind: ActivitySigninBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bind = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.signupLink.setOnClickListener{
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
            finish()
        }
        bind.signin.setOnClickListener{
            val intent = Intent(this,HomeView::class.java)
            startActivity(intent)
            finish()
        }
        bind.forgotPassword.setOnClickListener{
            val intent = Intent(this,ForgotPassword::class.java)
            startActivity(intent)
            finish()
        }
    }
}