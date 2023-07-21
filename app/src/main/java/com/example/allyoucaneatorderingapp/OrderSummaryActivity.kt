package com.example.allyoucaneatorderingapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class OrderSummaryActivity : AppCompatActivity() {

    private lateinit var selectedItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)

        val itemNameTextView = findViewById<TextView>(R.id.itemNameTextView)
        val itemDescriptionTextView = findViewById<TextView>(R.id.itemDescriptionTextView)
        val itemPhotoImageView = findViewById<ImageView>(R.id.itemPhotoImageView)

        //selectedItem = intent.getSerializableExtra("selectedItem") as? MenuItem
        selectedItem = intent.getParcelableExtra("selectedItem")

            ?: run {
                // Handle the case when the selected item is null or not of the correct type
                finish()
                return
            }

        populateOrderSummary(selectedItem, itemNameTextView, itemDescriptionTextView, itemPhotoImageView)

        findViewById<TextView>(R.id.confirmOrderButton).setOnClickListener {
            // Add logic here to handle confirming the order
            setResult(Activity.RESULT_OK)
            finish()
        }

        findViewById<TextView>(R.id.changeOrderButton).setOnClickListener {
            // Add logic here to change the order if needed
            val intent = Intent()
            intent.putExtra("changedItem", selectedItem)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        findViewById<TextView>(R.id.deleteOrderButton).setOnClickListener {
            // Add logic here to delete the order
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    private fun populateOrderSummary(
        menuItem: MenuItem,
        itemNameTextView: TextView,
        itemDescriptionTextView: TextView,
        itemPhotoImageView: ImageView
    ) {
        itemNameTextView.text = menuItem.name
        itemDescriptionTextView.text = menuItem.description
        itemPhotoImageView.setImageResource(menuItem.photoResId)
    }
}
