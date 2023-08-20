package com.example.allyoucaneatorderingapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.allyoucaneatorderingapp.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    // initializing SharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    // i have hardcoded user credentials here for 3 test users
    private val hardcodedUsers = listOf(
        User("Test User 1", "user1@email.com", "password1"),
        User("Test User 2", "user2@email.com", "password2"),
        User("Test User 3", "user3@email.com", "password3")
    )

    data class User(val name: String, val email: String, val password: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.goToLogin.setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.signup.setOnClickListener {
            val enteredName = binding.name.text.toString()
            val enteredEmail = binding.email.text.toString()
            val enteredPassword = binding.password.text.toString()

            if (enteredEmail.isEmpty() || enteredPassword.isEmpty() || enteredName.isEmpty()) {
                //using Toast to display a toast message if any field is empty
                Toast.makeText(
                    this,
                    "Please enter complete details",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // checking if the entered email is in the list of hardcoded users
                val matchedUser = hardcodedUsers.find { it.email == enteredEmail }

                if (matchedUser != null && matchedUser.password == enteredPassword) {
                    // saving user credentials to SharedPreferences
                    val editor = sharedPreferences.edit()
                    editor.putString("user_email", enteredEmail)
                    editor.putString("user_password", enteredPassword)
                    editor.apply()

                    //display successful message
                    Toast.makeText(
                        this,
                        "Registration Successful.",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(Intent(this@SignupActivity, ChooseLocationActivity::class.java))
                } else {
                    Toast.makeText(
                        this,
                        "Invalid credentials. Please check your details.", //display error message for invalid credentials.
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}

