package com.example.mentalhealthapp.yoga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.FragmentYogaBinding

class YogaFragment : Fragment() {

    private lateinit var binding:FragmentYogaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_yoga, container, false)

        binding= FragmentYogaBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}