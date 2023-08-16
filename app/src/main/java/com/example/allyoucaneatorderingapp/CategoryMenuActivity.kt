package com.example.allyoucaneatorderingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryMenuActivity : AppCompatActivity() {

    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_menu)

        val selectedCategory = intent.getStringExtra("selectedCategory")

        // Fetch menu items for the selected category based on 'selectedCategory'
        // For demonstration purposes, let's assume you have a function to get menu items by category
        val menuItems = getMenuItemsForCategory(selectedCategory)

        menuRecyclerView = findViewById(R.id.menuRecyclerView)
        menuAdapter = MenuAdapter(menuItems, ::onMenuItemClick, ::onAddToCartClick)
        menuRecyclerView.layoutManager = LinearLayoutManager(this)
        menuRecyclerView.adapter = menuAdapter
    }

    private fun onMenuItemClick(menuItem: MenuItem) {
        // Handle item click if needed
    }

    private fun onAddToCartClick(menuItem: MenuItem) {
        // Handle add to cart click if needed
    }

    // This is just a placeholder function to simulate fetching menu items by category
    private fun getMenuItemsForCategory(category: String?): List<MenuItem> {
        // You can replace this with your actual logic to fetch menu items by category
        return mutableListOf(
            MenuItem("Item 1", "Description 1", R.drawable.ic_launcher_foreground),
            MenuItem("Item 2", "Description 2", R.drawable.ic_launcher_foreground),
            // Add more menu items as needed
        )
    }
}
