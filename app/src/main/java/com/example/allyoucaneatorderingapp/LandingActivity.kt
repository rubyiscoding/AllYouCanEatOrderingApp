package com.example.allyoucaneatorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val categoryAppetizer: TextView = findViewById(R.id.categoryBurgers)
        val categoryPopularItems: TextView = findViewById(R.id.categoryPopularItems)

        // Set a click listener for the "Popular items" category
        categoryPopularItems.setOnClickListener {
            // Redirect the user to the MainActivity when the "Popular items" category is clicked
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Add logic or UI setup specific to the LandingActivity if needed


    }
}
