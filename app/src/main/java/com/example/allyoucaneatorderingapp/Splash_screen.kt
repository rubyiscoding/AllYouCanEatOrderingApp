package com.example.allyoucaneatorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import androidx.core.content.ContextCompat

class Splash_Screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val window: Window = this@Splash_Screen.getWindow()
        window.statusBarColor = ContextCompat.getColor(this@Splash_Screen,R.color.white)

        super.onCreate(savedInstanceState)
        //using a handler to delay the execution of code
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            //creating an intent that navigates to the login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },1000)
    }
}