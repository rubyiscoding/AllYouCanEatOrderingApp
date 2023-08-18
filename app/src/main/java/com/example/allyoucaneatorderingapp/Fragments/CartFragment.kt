package com.example.allyoucaneatorderingapp.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allyoucaneatorderingapp.CartAdapter
import com.example.allyoucaneatorderingapp.R
import com.example.allyoucaneatorderingapp.databinding.FragmentCartBinding
import com.example.allyoucaneatorderingapp.pay_out

class CartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("Burger","Sandwich","Mo:Mo")
        val cartItemPrice = listOf("$ 7.85","$ 5.8","$ 10.39")
        val cartImage = listOf(R.drawable.burger, R.drawable.sandwich,R.drawable.momos)
        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycler.adapter = adapter

        binding.proceed.setOnClickListener {
            val intent = Intent(requireContext(),pay_out::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {
    }
}