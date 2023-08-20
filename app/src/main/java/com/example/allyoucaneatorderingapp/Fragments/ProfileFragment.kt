package com.example.allyoucaneatorderingapp.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.allyoucaneatorderingapp.LoginActivity
import com.example.allyoucaneatorderingapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.signout.setOnClickListener {

            // Start the login activity
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }

        // Check if there are arguments containing "city" key
        val args = arguments
        if (args != null && args.containsKey("city")) {
            val selectedCity = args.getString("city")
            binding.address.setText(selectedCity)
        }

        return binding.root
    }
}
