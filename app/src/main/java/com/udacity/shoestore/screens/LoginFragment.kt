package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginBinding
import kotlinx.android.synthetic.main.login.*


class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: LoginBinding = DataBindingUtil.inflate(inflater, R.layout.login, container,
            false)

        binding.createButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.signinButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}