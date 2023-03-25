package com.example.quizziepie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.quizziepie.databinding.ActivityForgotPassBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPass : AppCompatActivity() {
    lateinit var binding: ActivityForgotPassBinding
    var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val email = binding.resetPass.text.toString()


        binding.forgotBtn.setOnClickListener {

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.resetPass.error = "Please Enter Valid Email"
                binding.resetPass.requestFocus()
                Toast.makeText(this,"Enter Email Address.",Toast.LENGTH_SHORT).show()
            }else{
                auth.sendPasswordResetEmail(email)
                    .addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage?.toString(),Toast.LENGTH_LONG).show()
                    }
                    .addOnSuccessListener {
                        Toast.makeText(this,"Please check your mail | Spam folder",Toast.LENGTH_LONG).show()
                        val intent = Intent(this,SignIn::class.java)
                        startActivity(intent)
                    }

            }

        }

    }
}