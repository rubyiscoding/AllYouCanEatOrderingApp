package com.example.allyoucaneatorderingapp


data class CartItem(
    val name: String,
    val description: String,
    val price: Double,
    var quantity: Int
)

