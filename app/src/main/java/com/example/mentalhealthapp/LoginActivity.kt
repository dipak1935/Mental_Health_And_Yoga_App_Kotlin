package com.example.mentalhealthapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val buttonLogin=findViewById<Button>(R.id.button_login)

        buttonLogin.setOnClickListener {

            val intent=Intent(this,MainActivity::class.java)

            startActivity(intent)
        }

    }
}