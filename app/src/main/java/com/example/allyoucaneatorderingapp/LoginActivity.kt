package com.example.allyoucaneatorderingapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.allyoucaneatorderingapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    // initializing SharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.goToSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.forgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener {
            val enteredEmail = binding.email1.text.toString()
            val enteredPassword = binding.password1.text.toString()

            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter complete details.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // retrieve the saved user credentials from SharedPreferences
                val savedEmail = sharedPreferences.getString("user_email", "")
                val savedPassword = sharedPreferences.getString("user_password", "")

                if (enteredEmail == savedEmail && enteredPassword == savedPassword) {
                    // Successful login
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                } else {
                    Toast.makeText(
                        this,
                        "Authentication failed. Please check your credentials.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}


