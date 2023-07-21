package com.example.allyoucaneatorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    private val menuItems = mutableListOf<MenuItem>()

    private val orderSummaryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            // Handle the result if needed
            // For example, you can access the data from the result Intent like this:
            // val data: Intent? = result.data
            // Update the order or perform any other necessary actions based on the result data

            val cartItems = result.data?.getSerializableExtra("cartItems") as? ArrayList<CartItem>
            if (cartItems != null) {
                this.cartItems.clear()
                this.cartItems.addAll(cartItems)
                menuAdapter.notifyDataSetChanged() // Notify the menuAdapter about the change
                updateCartIcon()
                updateTotalCost() // Update the total cost in the CartActivity
            }
        }
    }

    private fun updateTotalCost() {
        TODO("Not yet implemented")
    }

    private val cartItems = mutableListOf<CartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMenuItems()

        menuRecyclerView = findViewById(R.id.menuRecyclerView)
        menuAdapter = MenuAdapter(menuItems, ::onMenuItemClick, ::onAddToCartClick)
        menuRecyclerView.layoutManager = LinearLayoutManager(this)
        menuRecyclerView.adapter = menuAdapter

        val cartFab = findViewById<FloatingActionButton>(R.id.cartFab)
        cartFab.setOnClickListener {
            val intent = Intent(this@MainActivity, CartActivity::class.java)
            intent.putExtra("cartItems", ArrayList(cartItems)) // Pass the cart items to CartActivity
            orderSummaryLauncher.launch(intent)
        }
    }

    private fun initMenuItems() {
        // Add menu items here
        menuItems.apply {
            add(MenuItem("Mo:Mo", "Steamed bite-size dumplings made with a spoonful " +
                    "of seasoned meat or vegetable stuffing wrapped in dough, accompanied by a freshly " +
                    "made hot and fiery tomato chutney.", R.drawable.item1))
            add(MenuItem("Dal-Bhat", "Dal, Bhaat, Tarkari and Meat (lentil soup, " +
                    "rice, green vegetable) along with Kanchhemba (Buckwheat finger chips) the" +
                    " Mustang Alu topped with Jimbu (Himalayan leaf garlic) and a generous dollop of ghee.",
                        R.drawable.item2))
            add(MenuItem("Pani-Puri", "Crispy, hollow deep-fried puffed bread, " +
                    "traditionally stuffed with masala, chopped onion, and flavored with spicy " +
                    "or sweet-savoury pani (water) to be eaten promptly before becoming soft" +
                    " and soggy.", R.drawable.item3))
            // Add more menu items as needed
        }
    }

    private fun onMenuItemClick(menuItem: MenuItem) {
        // Add the selected item to the cart
        cartItems.add(CartItem(menuItem.name, menuItem.description, 0.0, 1))
        updateCartIcon()
    }

    private fun onAddToCartClick(menuItem: MenuItem) {
        // Handle adding the selected item to the cart
        cartItems.add(CartItem(menuItem.name, menuItem.description, 0.0, 1))
        updateCartIcon()
    }

    private fun updateCartIcon() {
        // Update the cart icon to show the number of items in the cart
        val cartFab = findViewById<FloatingActionButton>(R.id.cartFab)
        cartFab.setImageResource(R.drawable.cart)
        cartFab.contentDescription = "${cartItems.size} items in the cart"
    }
}
