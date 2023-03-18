package com.example.quizziepie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizziepie.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.signInForgetPass.setOnClickListener {
            val intent = Intent(this,ForgotPass::class.java)
            startActivity(intent)
        }

        binding.signInBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        binding.signUpDontHave.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

    }
}