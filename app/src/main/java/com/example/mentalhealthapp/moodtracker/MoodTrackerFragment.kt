package com.example.mentalhealthapp.moodtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.FragmentHomeBinding
import com.example.mentalhealthapp.databinding.FragmentMoodTrackerBinding

class MoodTrackerFragment : Fragment() {

    private lateinit var binding: FragmentMoodTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=FragmentMoodTrackerBinding.inflate(inflater,container,false)

        return binding.root

    }
}