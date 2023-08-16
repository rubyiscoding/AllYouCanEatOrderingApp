package com.example.allyoucaneatorderingapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem as AndroidMenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class OrderSummaryActivity : AppCompatActivity() {

    private lateinit var selectedItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val itemNameTextView = findViewById<TextView>(R.id.itemNameTextView)
        val itemDescriptionTextView = findViewById<TextView>(R.id.itemDescriptionTextView)
        val itemPhotoImageView = findViewById<ImageView>(R.id.itemPhotoImageView)

        selectedItem = intent.getParcelableExtra("selectedItem")
            ?: run {
                finish()
                return
            }

        populateOrderSummary(selectedItem, itemNameTextView, itemDescriptionTextView, itemPhotoImageView)

        findViewById<TextView>(R.id.confirmOrderButton).setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        findViewById<TextView>(R.id.changeOrderButton).setOnClickListener {
            val intent = Intent()
            intent.putExtra("changedItem", selectedItem)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        findViewById<TextView>(R.id.deleteOrderButton).setOnClickListener {
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

    override fun onOptionsItemSelected(item: AndroidMenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
