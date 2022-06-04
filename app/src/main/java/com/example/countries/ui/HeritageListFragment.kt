package com.example.countries.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.countries.R
import com.example.countries.databinding.FragmentHeritageListBinding

class HeritageListFragment : Fragment() {
    private val viewModel: HeritageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHeritageListBinding.inflate(inflater)
        viewModel.getHeritageList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = HeritageListAdapter(HeritageListener { heritage ->
            viewModel.onHeritageClicked(heritage)
            findNavController()
                .navigate(R.id.action_heritageListFragment_to_heritageDetailFragment)
        })

        return binding.root
    }
}