package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoelist.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel : ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoeListViewModel = viewModel
        binding.shoe = viewModel.shoe.value

        binding.cancelButton.setOnClickListener {
            viewModel.addShoe(binding.shoe!!)
            viewModel.shoe.value?.name = ""
            viewModel.shoe.value?.size = -1.0
            viewModel.shoe.value?.company = ""
            viewModel.shoe.value?.description = ""
            findNavController().navigateUp()
        }

        binding.saveButton.setOnClickListener {
            viewModel.addShoe(binding.shoe!!)
            binding.shoe!!.name = ""
            binding.shoe!!.size = -1.0
            binding.shoe!!.company = ""
            binding.shoe!!.description = ""
            findNavController().navigateUp()
        }

        binding.lifecycleOwner = this

        return binding.root
    }

}