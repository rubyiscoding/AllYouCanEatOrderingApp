package com.example.allyoucaneatorderingapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allyoucaneatorderingapp.MenuAdapter
import com.example.allyoucaneatorderingapp.R
import com.example.allyoucaneatorderingapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    //original menu data
    private val originalMenuFoodName = listOf("Burger","Sandwich","Mo:Mo","Stir-fry Noodles","Special Pizza","Milkshake")
    private val originalMenuItemPrice = listOf("$ 7.85","$ 5.8","$ 10.39","$4.31","$15.92","$4.48")
    private val originalMenuImage = listOf(R.drawable.burger, R.drawable.sandwich,R.drawable.momos,R.drawable.chowmein, R.drawable.pizza,R.drawable.shake)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //filtered menu data
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuFoodPrice =mutableListOf<String>()
    private val filteredMenuFoodImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuFoodName,filteredMenuFoodPrice,filteredMenuFoodImage,requireContext())
        binding.recyclerSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerSearch.adapter = adapter

        // Set up the SearchView and show all menu items initially
        setupServiceView()
        showAllMenu()
        return binding.root
    }

    //show all menu items
    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuFoodPrice.clear()
        filteredMenuFoodImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuFoodPrice.addAll(originalMenuItemPrice)
        filteredMenuFoodImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    // Setup the SearchView and define its behavior
    private fun setupServiceView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    // now we filter menu items based on the search query
    private fun filterMenuItems(query: String){
        filteredMenuFoodName.clear()
        filteredMenuFoodPrice.clear()
        filteredMenuFoodImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuFoodPrice.add(originalMenuItemPrice[index])
                filteredMenuFoodImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {
    }
}