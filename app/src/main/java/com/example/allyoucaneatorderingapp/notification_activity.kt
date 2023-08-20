package com.example.allyoucaneatorderingapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allyoucaneatorderingapp.databinding.ActivityNotificationBinding

class notification_activity : AppCompatActivity() {
    private lateinit var binding : ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true

        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //sample notification data
        val notification = listOf("Your order has been Cancelled Successfully."
                                  ,"Congrats! Your order has been placed"
                                  ,"Your order is on your way.")

        //initializing the notification adapter
        val adapter = notificationAdapter(ArrayList(notification))
        binding.notificationRecycler.adapter = adapter //sets the adapter for notifiaction recycler view
        binding.notificationRecycler.layoutManager = LinearLayoutManager(this) //sets the layout manager for the notification recycler view (here, LinearLayoutManager)
    }
}