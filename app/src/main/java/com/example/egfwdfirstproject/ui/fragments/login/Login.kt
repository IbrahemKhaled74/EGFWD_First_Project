package com.example.egfwdfirstproject.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.egfwdfirstproject.R
import com.example.egfwdfirstproject.databinding.FragmentInstructionBinding
import com.example.egfwdfirstproject.databinding.FragmentLoginBinding

class Login : Fragment() {

    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_welcome)
        }
        binding.create.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_welcome)
        }
    }


}