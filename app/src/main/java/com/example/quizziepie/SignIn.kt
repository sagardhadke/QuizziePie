package com.example.quizziepie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.quizziepie.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    var auth = FirebaseAuth.getInstance()
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

            val email = binding.signInEmail.text.toString()
            val password = binding.signInPassword.text.toString()
            val checkBox = binding.signInCheckbox


            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.signInEmail.error = "Enter Valid Email"
                binding.signInEmail.requestFocus()
                Toast.makeText(this,"Enter Your Email",Toast.LENGTH_SHORT).show()
            }else if (password.isEmpty()){
                binding.signInPassword.length()>=8
                binding.signInPassword.error = "Enter Valid Password"
                binding.signInPassword.requestFocus()
                Toast.makeText(this,"Enter Valid Password",Toast.LENGTH_SHORT).show()
            }else if (checkBox.isChecked){
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCanceledListener {
                        Toast.makeText(this,"Login Failed Please try again later",Toast.LENGTH_LONG).show()
                    }
                    .addOnSuccessListener {
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage?.toString(),Toast.LENGTH_LONG).show()
                    }

            }else{
                binding.signInCheckbox.requestFocus()
                binding.signInCheckbox.error = "accept Terms and condition"
                Toast.makeText(this,"Please accept Terms and condition",Toast.LENGTH_SHORT).show()
            }

        }

        binding.signUpDontHave.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

    }
}