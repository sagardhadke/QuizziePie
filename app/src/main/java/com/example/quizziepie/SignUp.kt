package com.example.quizziepie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.quizziepie.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
   private lateinit var binding: ActivitySignUpBinding

    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.signUpBtn.setOnClickListener {
            val email = binding.signUpEmail.text.toString()
            val password = binding.signUpPassword.text.toString()
            val confirmpass = binding.signUpConfirmPassword.text.toString()
            val check = password == confirmpass

            val name = binding.signUpName.text.toString()

            if (name.isEmpty()) {
                binding.signUpName.error = "Enter Your Name"
                binding.signUpName.requestFocus()
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    binding.signUpEmail.error = "Enter Valid Email"
                    binding.signUpEmail.requestFocus()
                    Toast.makeText(this,"Enter Email Address.",Toast.LENGTH_SHORT).show()
            }
            else if (password.isEmpty()) {
                binding.signUpPassword.length()>=8
                binding.signUpPassword.error = "Enter Valid Password"
                binding.signUpPassword.requestFocus()
                Toast.makeText(this,"Enter Valid Password",Toast.LENGTH_SHORT).show()
            } else if (check.not()){
                binding.signUpConfirmPassword.requestFocus()
                binding.signUpConfirmPassword.error = "Password Don't Match"
                Toast.makeText(this,"Password Don't Match",Toast.LENGTH_SHORT).show()
            } else if (binding.signCheckbox.isChecked){

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCanceledListener {
                        Toast.makeText(
                            this,
                            "Sign up Failed Please try again later",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .addOnSuccessListener {
                        Toast.makeText(this, it.user?.email.toString(), Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage?.toString(), Toast.LENGTH_LONG)
                            .show()
                    }

            }else{
                binding.signCheckbox.error = "Please check Terms and condition"
                binding.signCheckbox.requestFocus()
                Toast.makeText(this,"Please Accept Terms and condition.",Toast.LENGTH_SHORT).show()
            }



            binding.signInAlreadyHave.setOnClickListener {
                    val intent = Intent(this, SignIn::class.java)
                    startActivity(intent)
                    finish()
            }
        }


    }
}