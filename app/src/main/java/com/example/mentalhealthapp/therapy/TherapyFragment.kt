package com.example.mentalhealthapp.therapy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mentalhealthapp.databinding.FragmentTherapyBinding

class TherapyFragment : Fragment() {

    private lateinit var binding: FragmentTherapyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentTherapyBinding.inflate(inflater,container,false)

        return binding.root

    }
}