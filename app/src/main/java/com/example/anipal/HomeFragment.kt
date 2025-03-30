package com.example.anipal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val profile = view.findViewById<ImageView>(R.id.profile)

        profile.setOnClickListener {
            val intent = Intent(requireContext(), Profile::class.java)
            startActivity(intent)
        }
        val card1 = view.findViewById<LinearLayout>(R.id.trending_card1)

        card1.setOnClickListener{
            val intent = Intent(requireContext(), TrendingCard::class.java)
            startActivity(intent)
        }


        return view
    }
}