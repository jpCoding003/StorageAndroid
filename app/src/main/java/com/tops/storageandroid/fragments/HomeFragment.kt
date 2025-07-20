package com.tops.storageandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tops.storageandroid.Adapter.MyAdapter
import com.tops.storageandroid.Entity.Employe
import com.tops.storageandroid.R
import com.tops.storageandroid.ViewMOdel.EmployeViewModel
import com.tops.storageandroid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val employeviewmodel: EmployeViewModel by viewModels()
    private lateinit var adapter: MyAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvEmployees.layoutManager = LinearLayoutManager(requireContext())
        adapter = MyAdapter(mutableListOf())
        binding.rvEmployees.adapter = adapter

        employeviewmodel.employes.observe(viewLifecycleOwner, Observer{
            list-> adapter.updateList(list as MutableList<Employe>)
        })

        binding.btnaddEmploye.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addEmployeFragment)
        }
    }

}