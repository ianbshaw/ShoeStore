package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    //private lateinit var shoeList: MutableList<Shoe>

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf(
            Shoe("AF1", 10.0, "Nike", "Sneakers", listOf("","")),
            Shoe("Sketchers", 9.0, "Sketchers", "Sneakers", listOf("","")),
            Shoe("New Balance", 12.5, "New Balance", "Running Shoes", listOf("","")),
            Shoe("Rebok", 11.0, "Rebok", "Running Shoes", listOf("",""))
        )

    }

}