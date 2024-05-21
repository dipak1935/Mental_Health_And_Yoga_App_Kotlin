package com.example.mentalhealthapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mentalhealthapp.MainActivity
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding

    private lateinit var auth:FirebaseAuth


    // checking if user already logged in
    override fun onStart() {
        super.onStart()

        val currentUser:FirebaseUser? =auth.currentUser

        if(currentUser!=null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // initialising firebase auth
        auth=FirebaseAuth.getInstance()








        // setting sign up button click

        binding.buttonSignUp.setOnClickListener {

            // get data from editText fields

            val name=binding.editTextName.text.toString()
            val email=binding.editTextEmail.text.toString()
            val mobileNumber=binding.editTextMobileNumber.text.toString()
            val password=binding.editTextPassword.text.toString()

            // checking if any fields are empty

            if(name.isEmpty() || email.isEmpty() || mobileNumber.isEmpty() || password.isEmpty()){

                Toast.makeText(this,"Please fill all the details",Toast.LENGTH_SHORT).show()

            }
            else{

                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener { task->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Signing Up Successful",Toast.LENGTH_SHORT).show()

                            startActivity(Intent(this,MainActivity::class.java))
                            finish()

                        }
                        else{
                            Toast.makeText(this,"Signing Up Failed",Toast.LENGTH_SHORT).show()
                        }
                    }
            }


        }

    }
}