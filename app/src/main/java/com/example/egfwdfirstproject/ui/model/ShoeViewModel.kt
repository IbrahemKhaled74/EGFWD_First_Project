package com.example.egfwdfirstproject.ui.model

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    val shoeName = ObservableField<String>()
    val shoeCompany = ObservableField<String>()
    val shoeSize = ObservableField<String>()
    val shoeDesc = ObservableField<String>()
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val toast = MutableLiveData<Boolean>()

    var shoeList: LiveData<MutableList<Shoe>> = _shoeList

    private val shoes: MutableList<Shoe> = mutableListOf()

    var navigator: Navigator? = null


    fun addShoe() {
        if (validate()) {
            shoes.add(
                Shoe(
                    name = shoeName.get().toString(),
                    size = shoeSize.get().toString(),
                    company = shoeCompany.get().toString(),
                    description = shoeDesc.get().toString(),
                )
            )

            _shoeList.value = shoes
            navigator?.goToShoeList()

            shoeName.set("")
            shoeSize.set("")
            shoeCompany.set("")
            shoeDesc.set("")
        } else {
            toast.value = false
            _shoeList.value = shoes
            navigator?.goToShoeList()

        }


    }

    fun validate(): Boolean {
        var validate = true
        toast.value = true
        if (shoeName.get().isNullOrBlank()) {
            toast.value = false
            validate = false
        }
        if (shoeSize.get().isNullOrBlank()) {
            toast.value = false
            validate = false

        }
        if (shoeCompany.get().isNullOrBlank()) {
            toast.value = false
            validate = false


        }
        if (shoeDesc.get().isNullOrBlank()) {
            toast.value = false
            validate = false

        }

        return validate

    }


}