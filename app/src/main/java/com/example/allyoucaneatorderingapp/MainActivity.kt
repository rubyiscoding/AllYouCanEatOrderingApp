package com.example.allyoucaneatorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    private val menuItems = mutableListOf<MenuItem>()

    // Create an ActivityResultLauncher for starting OrderSummaryActivity
    private val orderSummaryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            // Handle the result if needed
            // For example, you can access the data from the result Intent like this:
            // val data: Intent? = result.data
            // Update the order or perform any other necessary actions based on the result data
        }
    }

    private val cartItems = mutableListOf<MenuItem>()
    private lateinit var cartItemCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize cart item count TextView
        cartItemCountTextView = findViewById(R.id.cartItemCountTextView)

        initMenuItems()

        menuRecyclerView = findViewById(R.id.menuRecyclerView)
        menuAdapter = MenuAdapter(menuItems, { selectedItem ->
            val intent = Intent(this@MainActivity, OrderSummaryActivity::class.java)
            intent.putExtra("selectedItem", selectedItem)
            orderSummaryLauncher.launch(intent) // Start OrderSummaryActivity using the launcher
        }, { selectedItem ->
            cartItems.add(selectedItem)
            updateCartItemCount()
        })

        menuRecyclerView.layoutManager = LinearLayoutManager(this)
        menuRecyclerView.adapter = menuAdapter
    }

    private fun initMenuItems() {
        menuItems.apply {
            add(MenuItem("Item 1", "Description of Item 1", R.drawable.item1))
            add(MenuItem("Item 2", "Description of Item 2", R.drawable.item2))
            add(MenuItem("Item 3", "Description of Item 3", R.drawable.item3))
            // Add more menu items as needed
        }
    }

    private fun updateCartItemCount() {
        val cartItemCount = cartItems.size
        cartItemCountTextView.text = cartItemCount.toString()
        if (cartItemCount > 0) {
            cartItemCountTextView.visibility = View.VISIBLE
        } else {
            cartItemCountTextView.visibility = View.INVISIBLE
        }
    }

    companion object {
        const val REQUEST_ORDER_SUMMARY = 100
    }
}
