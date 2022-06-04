package com.example.countries.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.countries.R
import com.example.countries.databinding.FragmentCountryFrontBinding


class CountryFrontFragment : Fragment() {

    private var binding: FragmentCountryFrontBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentCountryFrontBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.countryFrontFragment = this
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_countryFrontFragment_to_countryListFragment)
    }

    fun goToNextScreen2() {
        findNavController().navigate(R.id.action_countryFrontFragment_to_heritageListFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}