package com.example.allyoucaneatorderingapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.allyoucaneatorderingapp.databinding.NotificationItemViewBinding

class notificationAdapter(private var notification: ArrayList<String>): RecyclerView.Adapter<notificationAdapter.notificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notificationViewHolder {
        val binding = NotificationItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return notificationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notification.size  //returns the number of items in the dataset
    }

    override fun onBindViewHolder(holder: notificationViewHolder, position: Int) {
        holder.bind(position) //this binds data to the views in each item of the RecyclerView
    }
    inner class notificationViewHolder(private val binding: NotificationItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.apply {
                notificationTextview.text = notification[position] //setting the text for the notification TextView
                notificationIcon.setImageResource(R.drawable.baseline_info_24)  //setting the icon for the notification
            }
        }
    }
}