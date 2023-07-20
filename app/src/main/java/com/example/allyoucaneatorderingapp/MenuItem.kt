package com.example.allyoucaneatorderingapp
import java.io.Serializable

data class MenuItem(
    val name: String,
    val description: String,
    val photoResId: Int
) : Serializable

