package com.example.quizziepie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizziepie.databinding.ActivityForgotPassBinding

class ForgotPass : AppCompatActivity() {
    lateinit var binding: ActivityForgotPassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}