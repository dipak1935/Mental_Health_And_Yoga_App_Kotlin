package com.example.mentalhealthapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalhealthapp.MainActivity
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.ActivitySignInBinding
import com.example.mentalhealthapp.databinding.ActivitySignUpBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSignIn.setOnClickListener {

            finish()
            startActivity(Intent(this,MainActivity::class.java))

        }

        binding.buttonSignUp.setOnClickListener {

            finish()
            startActivity(Intent(this,SignUpActivity::class.java))


        }





    }
}