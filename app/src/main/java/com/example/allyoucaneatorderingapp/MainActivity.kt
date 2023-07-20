package com.example.allyoucaneatorderingapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    private val menuItems = mutableListOf<MenuItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMenuItems()

        menuRecyclerView = findViewById(R.id.menuRecyclerView)
        menuAdapter = MenuAdapter(menuItems) { selectedItem ->
            val intent = Intent(this@MainActivity, OrderSummaryActivity::class.java)
            intent.putExtra("selectedItem", selectedItem)
            startActivityForResult(intent, REQUEST_ORDER_SUMMARY)
        }
        menuRecyclerView.layoutManager = LinearLayoutManager(this)
        menuRecyclerView.adapter = menuAdapter

    }
}
private fun initMenuItems() {
    menuItems.apply {
        add(MenuItem("Item 1", "Description of Item 1", R.drawable.item1))
        add(MenuItem("Item 2", "Description of Item 2", R.drawable.item2))
        add(MenuItem("Item 3", "Description of Item 3", R.drawable.item3))
        // Add more menu items as needed
    }
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == REQUEST_ORDER_SUMMARY && resultCode == RESULT_OK) {
        // Handle any changes to the order if needed
    }
}

companion object {
    const val REQUEST_ORDER_SUMMARY = 100
}
}