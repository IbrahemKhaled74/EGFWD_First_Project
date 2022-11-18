package com.example.egfwdfirstproject.ui.fragments.shoeList

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.egfwdfirstproject.R
import com.example.egfwdfirstproject.databinding.FragmentShoesListBinding
import com.example.egfwdfirstproject.ui.model.ShoeViewModel
import com.example.egfwdfirstproject.ui.model.Shoe
import com.google.android.material.snackbar.BaseTransientBottomBar.Duration


class ShoesList : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()
    lateinit var binding: FragmentShoesListBinding
    lateinit var shoeName: TextView
    lateinit var shoeSize: TextView
    lateinit var shoeDesc: TextView
    lateinit var shoeCompany: TextView
    lateinit var space:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes__list, container, false)
        setHasOptionsMenu(true)
        binding.item = viewModel



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.details.setOnClickListener {
            findNavController().navigate(R.id.action_shoes_List_to_shoeDetail)

        }
        //Observe from view model
        viewModel.toast.observe(viewLifecycleOwner){
            if (it){
                subscribeData()

            }else{
                Toast.makeText(requireContext(), "Plz Enter Data", Toast.LENGTH_SHORT).show()
                subscribeData()

            }
        }





    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)

    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.login) {
            findNavController().navigate(R.id.action_shoes_List_to_login2)
            return true
        }
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)
    }

//build Text Views
    private fun buildView(shoe: MutableList<Shoe>) {

        val size = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        shoe.forEach {
            shoe->
            shoeName = TextView(requireContext())
            shoeName.text = "Shoe Name : ${shoe.name}"
            shoeName.textSize = 22F
            shoeName.setTextColor(Color.BLACK)

            binding.liner.addView(
                shoeName, size
            )

            shoeCompany = TextView(requireContext())
            shoeCompany.text = "Shoe Company : ${shoe.company}"
            shoeCompany.textSize = 22F
            shoeCompany.setTextColor(Color.BLACK)

            binding.liner.addView(
                shoeCompany,
                size
            )


            shoeSize = TextView(requireContext())
            shoeSize.text = "Shoe Size : ${shoe.size}"
            shoeSize.textSize = 22F
            shoeSize.setTextColor(Color.BLACK)

            binding.liner.addView(
                shoeSize,
                size
            )

            shoeDesc = TextView(requireContext())
            shoeDesc.text = "Shoe Desc : ${shoe.description}"
            shoeDesc.textSize = 22F
            shoeDesc.setTextColor(Color.BLACK)

            binding.liner.addView(
                shoeDesc,
                size
            )
            space = TextView(requireContext())
            space.text = "--------------------------------"
            space.textSize = 20F
            space.setTextColor(Color.BLACK)

            binding.liner.addView(
                space,
                size
            )


        }


    }
    fun subscribeData(){
        viewModel.shoeList.observe(viewLifecycleOwner){
                shoes->
            buildView(shoes)
        }
    }

}