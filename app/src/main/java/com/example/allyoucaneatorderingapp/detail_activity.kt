package com.example.allyoucaneatorderingapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.allyoucaneatorderingapp.databinding.ActivityDetailBinding

class detail_activity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set a click listener for the "Back" button
        binding.back.setOnClickListener {
            finish() // finish the activity when the button is clicked to go back
        }
        // Get data from the intent to display details
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val image = intent.getIntExtra("image",0)

        // now we update the UI with the received data
        binding.detailImage.setImageResource(image)
        binding.detailFoodName.text = name
        binding.detailPrice.text = price

    }
}