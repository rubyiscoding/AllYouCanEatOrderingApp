package com.example.allyoucaneatorderingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allyoucaneatorderingapp.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private val cartItems = mutableListOf<CartItem>()
    private lateinit var binding: ActivityCartBinding
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cartAdapter = CartAdapter(cartItems, ::onQuantityChange, ::onRemoveItemClick)
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.cartRecyclerView.adapter = cartAdapter

        // Add cart items here (you can do it from MainActivity when adding items to the cart)
        // Example:
        // cartItems.add(CartItem("Item 1", "Description of Item 1", 10.99, 1))
        // cartItems.add(CartItem("Item 2", "Description of Item 2", 15.99, 2))
        // cartItems.add(CartItem("Item 3", "Description of Item 3", 7.99, 3))

        // Calculate and update total cost
        updateTotalCost()
    }

    private fun updateTotalCost() {
        var totalCost = 0.0
        for (item in cartItems) {
            totalCost += item.price * item.quantity
        }
        binding.totalCostTextView.text = getString(R.string.total_cost, "%.2f".format(totalCost))
    }

    private fun onQuantityChange(position: Int, quantity: Int) {
        cartItems[position].quantity = quantity
        cartAdapter.notifyItemChanged(position)
        updateTotalCost()
    }

    private fun onRemoveItemClick(position: Int) {
        cartItems.removeAt(position)
        cartAdapter.notifyItemRemoved(position)
        updateTotalCost()
    }
}
