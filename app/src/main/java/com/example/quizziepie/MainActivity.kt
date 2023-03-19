package com.example.quizziepie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizziepie.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.logout.setOnClickListener {

            auth.signOut()
            val intent = Intent(this,SignIn::class.java)
            startActivity(intent)
            Toast.makeText(this,"User Logout Successfully",Toast.LENGTH_LONG).show()
            finish()

        }

    }
}