package com.example.mentalhealthapp.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mentalhealthapp.MainActivity
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.ActivitySignInWelcomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignInWelcomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignInWelcomeBinding


    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()

        val currentUser: FirebaseUser? =auth.currentUser

        if(currentUser!=null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth=FirebaseAuth.getInstance()


        binding.buttonRegister.setOnClickListener {

            startActivity(Intent(this,SignUpActivity::class.java))
            finish()

        }

        binding.buttonSignIn.setOnClickListener {

            startActivity(Intent(this,SignInActivity::class.java))
            finish()

        }


    }
}