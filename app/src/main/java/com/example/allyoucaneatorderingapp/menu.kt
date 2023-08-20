package com.example.allyoucaneatorderingapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allyoucaneatorderingapp.databinding.ActivityMenuBinding

class menu : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true

        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        //menu items
        val menuFoodName = listOf("Burger","Sandwich","Mo:Mo","Stir-fry Noodles","Special Pizza","MilkShake")
        val menuItemPrice = listOf("$ 7.85","$ 5.8","$ 10.39","$4.31","$15.92","$4.48")
        val menuImage = listOf(R.drawable.burger, R.drawable.sandwich,R.drawable.momos,R.drawable.chowmein, R.drawable.pizza,R.drawable.shake)

        // create and set up the adapter for the menu items
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage), this)
        binding.menuRecycler.layoutManager = LinearLayoutManager(this)
        binding.menuRecycler.adapter = adapter
    }
}