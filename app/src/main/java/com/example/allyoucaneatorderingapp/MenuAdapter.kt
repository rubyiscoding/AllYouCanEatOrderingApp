package com.example.allyoucaneatorderingapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.allyoucaneatorderingapp.databinding.MenuItemViewBinding

class MenuAdapter(private val menuItems: MutableList<String>, private val menuItemPrice: MutableList<String>, private val MenuItemImage: MutableList<Int>,private val context: Context) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private val itemClickListener:OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuItems.size // returns the total number of menu items
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MenuViewHolder(private val binding: MenuItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            // setting a click listener for the item view
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                // lets create an intent to open the detail activity with item details
                val intent = Intent(context, detail_activity::class.java)
                intent.putExtra("name",menuItems.get(position))
                intent.putExtra("image",MenuItemImage.get(position))
                intent.putExtra("price",menuItemPrice.get(position))
                context.startActivity(intent)
            }
        }
        fun bind(position: Int){
            binding.apply {  // binding menu item data to the view
                foodNameMenu.text = menuItems[position]
                priceMenu.text = menuItemPrice[position]
                menuFoodImage.setImageResource(MenuItemImage[position])
            }
        }
    }
    interface OnClickListener {
        fun onItemClick(position: Int)
    }
}