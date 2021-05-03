package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_list.*
import kotlinx.android.synthetic.main.fragment_shoe_list.view.*
import java.util.*

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.createShoeButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        viewModel.shoeData.observe(viewLifecycleOwner, Observer { shoes ->
            for (i in shoes) {
                val textView = TextView(context)
                textView.text = i.name
                textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                binding.shoeListFragment.mainLayout.addView(textView)
            }
        })

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return super.onOptionsItemSelected(item)
    }

}