package com.example.anipal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.FragmentManager
import com.example.anipal.databinding.ActivityOnboarding1Binding
import com.example.anipal.databinding.FragmentOnBoarding4Binding

class OnBoarding4 : Fragment() {

    private lateinit var bind: FragmentOnBoarding4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind=FragmentOnBoarding4Binding.inflate(inflater,container,false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        view.startAnimation(fadeIn)

        bind.signUp.setOnClickListener{
            val intent = Intent(requireActivity(),SignUp::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

    }


}