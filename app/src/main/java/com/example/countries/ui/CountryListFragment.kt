package com.example.countries.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.countries.R
import com.example.countries.databinding.FragmentCountryListBinding

class CountryListFragment : Fragment() {
    private val viewModel: CountryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCountryListBinding.inflate(inflater)
        viewModel.getCountryList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = CountryListAdapter(CountryListener { country ->
            viewModel.onCountryClicked(country)
            findNavController()
                .navigate(R.id.action_countryListFragment_to_countryDetailFragment)
        })

        return binding.root
    }
}