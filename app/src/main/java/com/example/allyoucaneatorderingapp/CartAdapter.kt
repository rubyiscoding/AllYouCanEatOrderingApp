package com.example.allyoucaneatorderingapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.allyoucaneatorderingapp.databinding.CartItemViewBinding

class CartAdapter(private val cartItems: MutableList<String>, private val cartItemPrice: MutableList<String>,private val cartImage : MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    // initializing item quantities with a default value of 1 for each item
    private val itemQuantities = IntArray(cartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartItems.size // returns the total number of items in the cart
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class CartViewHolder(private val binding: CartItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position] // get the quantity for the current item
                cartFoodName.text = cartItems[position] // sets data to the views in the cart item layout
                cartFoodPrice.text = cartItemPrice[position]
                cartFoodImage.setImageResource(cartImage[position])
                cartQuantity.text = quantity.toString()
                decreaseQuantity.setOnClickListener {
                    decreaseQuan(position)
                }
                increaseQuantity.setOnClickListener {
                    increaseQuan(position)
                }
                deleteCartItem.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION){
                        deleteItem(position)
                    }
                }


            }
        }

        // decrease the item quantity if greater than 1, else delete the item
        private fun decreaseQuan(position: Int){
            if (itemQuantities[position]>1){
                itemQuantities[position]--
                binding.cartQuantity.text = itemQuantities[position].toString()
            }
            else{
                deleteItem(position)
            }
        }
        private fun increaseQuan(position: Int){
            // Increase the item quantity if less than 10
            if (itemQuantities[position]<10){
                itemQuantities[position]++
                binding.cartQuantity.text = itemQuantities[position].toString()
            }
        }
        private fun deleteItem(position: Int){
            // delete the item from the cart
            if (itemQuantities[position]>=1){
                cartItems.removeAt(position)
                cartImage.removeAt(position)
                cartItemPrice.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, cartItems.size)
            }
        }

    }
}