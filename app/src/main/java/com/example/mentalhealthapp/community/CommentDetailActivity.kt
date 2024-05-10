package com.example.mentalhealthapp.community

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.ActivityCommentDetailBinding

class CommentDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val heading=intent.getStringExtra("heading")
        val message=intent.getStringExtra("message")
        val name=intent.getStringExtra("name")
        val dateTime=intent.getStringExtra("dateTime")
        val image=intent.getIntExtra("profileImage",R.drawable.pic1)


        binding.textViewCommentHeading.text=heading
        binding.textViewCommentProfileName.text=name
        binding.textViewCommentMessage.text=message
        binding.textViewCommentTimeAndDate.text=dateTime
        binding.imageViewCommentProfilePic.setImageResource(image)



    }
}