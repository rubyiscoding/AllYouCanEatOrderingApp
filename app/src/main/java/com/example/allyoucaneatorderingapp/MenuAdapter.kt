package com.example.allyoucaneatorderingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MenuAdapter(
    private val menuItems: List<MenuItem>,
    private val onItemClick: (MenuItem) -> Unit,
    private val onAddToCartClick: (MenuItem) -> Unit // New parameter for handling cart functionality
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemName: TextView = itemView.findViewById(R.id.itemNameTextView)
        private val itemDescription: TextView = itemView.findViewById(R.id.itemDescriptionTextView)
        private val itemPhoto: ImageView = itemView.findViewById(R.id.itemPhotoImageView)
        private val addToCartButton: MaterialButton = itemView.findViewById(R.id.addToCartButton)

        fun bind(menuItem: MenuItem) {
            itemName.text = menuItem.name
            itemDescription.text = menuItem.description
            itemPhoto.setImageResource(menuItem.photoResId)

            itemView.setOnClickListener {
                onItemClick(menuItem)
            }

            addToCartButton.setOnClickListener {
                onAddToCartClick(menuItem) // Call the onAddToCartClick function with the selected item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.menu_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = menuItems[position]
        holder.bind(menuItem)
    }

    override fun getItemCount(): Int = menuItems.size
}
