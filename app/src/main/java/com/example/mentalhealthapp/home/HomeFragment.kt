package com.example.mentalhealthapp.home

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.FragmentHomeBinding

class HomeFragment:Fragment() {

    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding=FragmentHomeBinding.inflate(inflater,container,false)

        ActionBar.DISPLAY_SHOW_TITLE

        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}