package com.example.allyoucaneatorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.allyoucaneatorderingapp.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {

    // Using lazy initialization for the view binding
    val binding : ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationList = arrayOf("Sudbury", "Lively", "Azilda", "Coniston")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        binding.spinner.setAdapter(adapter)
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (parent != null){
                    binding.next.setOnClickListener {
                        val city = parent.selectedItem.toString()
                        // Start MainActivity with the selected city as an extra
                        val intent = Intent(this@ChooseLocationActivity,MainActivity::class.java)
                        intent.putExtra("city",city)
                        startActivity(intent)
                    }
                }

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}