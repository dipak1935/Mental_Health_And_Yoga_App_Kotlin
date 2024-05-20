package com.example.mentalhealthapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalhealthapp.login.SignInActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        },6000)

    }
}