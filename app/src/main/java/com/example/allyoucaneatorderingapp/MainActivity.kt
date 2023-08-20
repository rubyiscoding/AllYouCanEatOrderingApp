package com.example.allyoucaneatorderingapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.allyoucaneatorderingapp.Fragments.ProfileFragment
import com.example.allyoucaneatorderingapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragmentContainerView)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setupWithNavController(navController)

        binding.notificationsButton.setOnClickListener {
            startActivity(Intent(this, notification_activity::class.java))
        }

        // Check if there's an intent with "city" extra
        val cityName = intent.getStringExtra("city")
        if (cityName != null) {
            // Pass the selected city to the ProfileFragment
            val profileFragment = ProfileFragment()
            val bundle = Bundle()
            bundle.putString("city", cityName)
            profileFragment.arguments = bundle

            // Navigate to the ProfileFragment
            navController.navigate(R.id.profileFragment, bundle)
        }
    }
}
