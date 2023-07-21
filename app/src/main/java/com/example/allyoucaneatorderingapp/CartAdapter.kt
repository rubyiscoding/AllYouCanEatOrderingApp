package com.example.allyoucaneatorderingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private val cartItems: List<CartItem>,
    private val onQuantityChangeListener: (Int, Int) -> Unit,
    private val onRemoveItemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemName: TextView = itemView.findViewById(R.id.itemNameTextView)
        private val itemDescription: TextView = itemView.findViewById(R.id.itemDescriptionTextView)
        private val itemPrice: TextView = itemView.findViewById(R.id.itemPriceTextView)
        private val itemQuantity: TextView = itemView.findViewById(R.id.itemQuantityTextView)
        private val increaseQuantityButton: Button = itemView.findViewById(R.id.increaseQuantityButton)
        private val decreaseQuantityButton: Button = itemView.findViewById(R.id.decreaseQuantityButton)
        private val removeItemButton: Button = itemView.findViewById(R.id.removeItemButton)

        fun bind(cartItem: CartItem) {
            itemName.text = cartItem.name
            itemDescription.text = cartItem.description
            itemPrice.text = "$${"%.2f".format(cartItem.price)}"
            itemQuantity.text = cartItem.quantity.toString()

            increaseQuantityButton.setOnClickListener {
                onQuantityChangeListener(adapterPosition, cartItem.quantity + 1)
            }

            decreaseQuantityButton.setOnClickListener {
                if (cartItem.quantity > 1) {
                    onQuantityChangeListener(adapterPosition, cartItem.quantity - 1)
                }
            }

            removeItemButton.setOnClickListener {
                onRemoveItemClickListener(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.bind(cartItem)
    }

    override fun getItemCount(): Int = cartItems.size
}
