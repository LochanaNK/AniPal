package com.example.anipal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class TrendingCard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trending_card)

        if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.trending_frame, TrendingCardFragment())
                    .commit()
        }

    }
}

