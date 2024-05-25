package com.example.mentalhealthapp.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalhealthapp.MainActivity
import com.example.mentalhealthapp.R
import com.example.mentalhealthapp.databinding.ActivitySignInBinding
import com.example.mentalhealthapp.databinding.ActivitySignUpBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private lateinit var auth: FirebaseAuth

    private lateinit var googleSignInClient:GoogleSignInClient

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



        // google sign in works

        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()

        googleSignInClient= GoogleSignIn.getClient(this,gso)

        binding.buttonSignInWithGoogle.setOnClickListener {

            val signInClient=googleSignInClient.signInIntent

            launcher.launch(signInClient)
        }
//


    }
    private val launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        result->

        if(result.resultCode== Activity.RESULT_OK){

            val task=GoogleSignIn.getSignedInAccountFromIntent(result.data)


            if(task.isSuccessful){

                val account:GoogleSignInAccount?=task.result
                val credential=GoogleAuthProvider.getCredential(account?.idToken,null)
                auth.signInWithCredential(credential).addOnCompleteListener{

                    if(it.isSuccessful){


                        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainActivity::class.java))

                    }
                    else{
                        Toast.makeText(this, "Falied", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
        else{
            Toast.makeText(this, "Falied", Toast.LENGTH_SHORT).show()
        }
    }
    
}