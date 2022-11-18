package com.example.egfwdfirstproject.ui.fragments.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.egfwdfirstproject.R
import com.example.egfwdfirstproject.databinding.FragmentShoeDetailBinding
import com.example.egfwdfirstproject.ui.model.Navigator
import com.example.egfwdfirstproject.ui.model.ShoeViewModel

class ShoeDetail : Fragment(), Navigator {

    lateinit var binding: FragmentShoeDetailBinding
     val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item=viewModel
        viewModel.navigator=this

        binding.cancel.setOnClickListener {
            findNavController().navigateUp()
        }



    }

    override fun goToShoeList() {
        findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoesList())

    }


}