package com.example.allyoucaneatorderingapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.allyoucaneatorderingapp.databinding.ActivityCongratsBinding

class congrats_activity : AppCompatActivity() {

    private lateinit var binding: ActivityCongratsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true

        super.onCreate(savedInstanceState)
        binding = ActivityCongratsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.goHome.setOnClickListener {
            val intent = Intent(this@congrats_activity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}