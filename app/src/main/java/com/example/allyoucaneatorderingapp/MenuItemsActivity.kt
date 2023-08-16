package com.example.allyoucaneatorderingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MenuItemsActivity : AppCompatActivity() {

    private lateinit var category: String
    private lateinit var menuItemsRecyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_items)

        // Retrieve the selected category from the intent
        category = intent.getStringExtra("category") ?: ""

        // Initialize the menuItemsRecyclerView and menuItemsAdapter
        menuItemsRecyclerView = findViewById(R.id.menuItemsRecyclerView)
        menuItemsAdapter = MenuItemsAdapter(filterMenuItemsByCategory(category))
        menuItemsRecyclerView.layoutManager = LinearLayoutManager(this)
        menuItemsRecyclerView.adapter = menuItemsAdapter
    }

    private fun filterMenuItemsByCategory(category: String): List<MenuItem> {
        // Implement the logic to filter menu items based on the selected category
        return // Filtered list of menu items for the selected category
    }
}