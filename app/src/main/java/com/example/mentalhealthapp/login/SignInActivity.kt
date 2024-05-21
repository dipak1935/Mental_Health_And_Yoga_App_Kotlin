package com.example.mentalhealthapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalhealthapp.MainActivity
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.ActivitySignInBinding
import com.example.mentalhealthapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()

        val currentUser: FirebaseUser? =auth.currentUser

        if(currentUser!=null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.textViewSignUp.setOnClickListener {

            startActivity(Intent(this,SignUpActivity::class.java))
            finish()

        }


        // initialising firebase auth

        auth=FirebaseAuth.getInstance()

        binding.buttonSignIn.setOnClickListener {

            val email=binding.editTextEmail.text.toString()
            val password=binding.editTextPassword.text.toString()


            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
            else{

                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener { task->

                        if(task.isSuccessful){
                            Toast.makeText(this, "Sign In Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,MainActivity::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Sign In Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
    
}