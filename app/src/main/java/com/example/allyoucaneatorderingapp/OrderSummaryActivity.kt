package com.example.allyoucaneatorderingapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_order_summary.*

class OrderSummaryActivity : AppCompatActivity() {

    private lateinit var selectedItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)

        selectedItem = intent.getSerializableExtra("selectedItem") as MenuItem
        populateOrderSummary(selectedItem)

        confirmOrderButton.setOnClickListener {
            // Add logic here to handle confirming the order
            setResult(RESULT_OK)
            finish()
        }

        changeOrderButton.setOnClickListener {
            // Add logic here to change the order if needed
            val intent = Intent()
            intent.putExtra("changedItem", selectedItem)
            setResult(RESULT_OK, intent)
            finish()
        }

        deleteOrderButton.setOnClickListener {
            // Add logic here to delete the order
            setResult(RESULT_CANCELED)
            finish()
        }
    }

    private fun populateOrderSummary(menuItem: MenuItem) {
        itemNameTextView.text = menuItem.name
        itemDescriptionTextView.text = menuItem.description
        itemPhotoImageView.setImageResource(menuItem.photoResId)
    }
}
