package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    //private lateinit var shoeList: MutableList<Shoe>

    private val shoeList = mutableListOf<Shoe>()
    private val _shoeData = MutableLiveData<List<Shoe>>()
    val shoeData : LiveData<List<Shoe>>
        get() = _shoeData

    init {
        addShoe(Shoe("AF1", 10.0, "Nike", "Sneakers", listOf("","")))
        addShoe(Shoe("Sketchers", 9.0, "Sketchers", "Sneakers", listOf("","")))
        addShoe(Shoe("New Balance", 12.5, "New Balance", "Running Shoes", listOf("","")))
        addShoe(Shoe("Rebok", 11.0, "Rebok", "Running Shoes", listOf("","")))

        _shoeData.value = shoeList
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
        _shoeData.value = shoeList
    }

}