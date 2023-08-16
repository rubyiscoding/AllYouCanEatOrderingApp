package com.example.allyoucaneatorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val categoryAppetizer: TextView = findViewById(R.id.categoryAppetizer)
        val categoryPizzas: TextView = findViewById(R.id.categoryPizzas)
        val categoryPopularItems: TextView = findViewById(R.id.categoryPopularItems)

        // Set a click listener for the "Popular items" category
        categoryPopularItems.setOnClickListener {
            // Redirect the user to the MainActivity when the "Popular items" category is clicked
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Set a click listener for the "Appetizer" category
        categoryAppetizer.setOnClickListener {
            // Start the CategoryMenuActivity with "Appetizer" category
            startCategoryMenuActivity("Appetizer")
        }

        // Set a click listener for the "Pizzas" category
        categoryPizzas.setOnClickListener {
            // Start the CategoryMenuActivity with "Pizzas" category
            startCategoryMenuActivity("Pizzas")
        }
    }

    private fun startCategoryMenuActivity(selectedCategory: String) {
        val intent = Intent(this, CategoryMenuActivity::class.java)
        intent.putExtra("selectedCategory", selectedCategory)
        startActivity(intent)
    }
}
