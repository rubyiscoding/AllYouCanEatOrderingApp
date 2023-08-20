package com.example.allyoucaneatorderingapp.Fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.allyoucaneatorderingapp.PopularAdapter
import com.example.allyoucaneatorderingapp.R
import com.example.allyoucaneatorderingapp.databinding.FragmentHomeBinding
import com.example.allyoucaneatorderingapp.MenuActivity

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        // navigates to the menu when the "View Menu" button is clicked
        binding.viewMenu.setOnClickListener {
            startActivity(Intent(requireContext(), MenuActivity::class.java))
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setting up carousels
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner_1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner_2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner_3, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object:ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage= "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage, Toast.LENGTH_SHORT).show()
            }
        })
        //setting up the popular food items RecyclerView
        val foodName = listOf("Burger","Sandwich","Mo:Mo")
        val Price = listOf("$ 7.85","$ 5.8","$ 10.39")
        val popularFoodImages = listOf(R.drawable.burger,R.drawable.sandwich, R.drawable.momos)
        val adapter = PopularAdapter(foodName, popularFoodImages, Price,requireContext())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }


    companion object {
    }
}