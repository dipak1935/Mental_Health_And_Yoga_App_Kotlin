package com.example.mentalhealthapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalhealthapp.login.SignInActivity
import com.example.mentalhealthapp.login.SignInWelcomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, SignInWelcomeActivity::class.java))
            finish()
        },6000)

    }
}