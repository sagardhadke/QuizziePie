package com.example.quizziepie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.quizziepie.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()



        Handler(Looper.getMainLooper()).postDelayed({


            if (auth.currentUser != null){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this,SignIn::class.java)
                startActivity(intent)
                finish()
            }


        },2500)

    }
}