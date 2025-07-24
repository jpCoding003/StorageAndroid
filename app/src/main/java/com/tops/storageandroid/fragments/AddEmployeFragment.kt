package com.tops.storageandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tops.storageandroid.Entity.Employe
import com.tops.storageandroid.R
import com.tops.storageandroid.ViewMOdel.EmployeViewModel
import com.tops.storageandroid.databinding.FragmentAddEmployeBinding
import kotlin.getValue


class AddEmployeFragment : Fragment() {

    private lateinit var binding: FragmentAddEmployeBinding
    private val employeviewmodel: EmployeViewModel by viewModels()
    private var currentEmploye: Employe? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddEmployeBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emp = arguments?.getSerializable("employee_data") as? Employe
        currentEmploye = emp
        currentEmploye?.let { emp ->
            binding.etName.setText(emp.EmpName)
            binding.etEmail.setText(emp.EmpEmail)
            binding.etAddress.setText(emp.EmpAddress)
            binding.etPhone.setText(emp.EmpPhone.toString())
            binding.etRole.setText(emp.EmpRole)
            binding.btnSubmit.text = "Update Employee"
        }


        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val address = binding.etAddress.text.toString()
            val phone = binding.etPhone.text.toString().toLong()
            val role = binding.etRole.text.toString()

            if ( name.isEmpty() || email.isEmpty() || address.isEmpty() || phone.toString().isEmpty() || role.isEmpty()){
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (currentEmploye == null) {
                employeviewmodel.addEmp(name, email, address, phone, role)
                Toast.makeText(requireContext(), "Employee added", Toast.LENGTH_SHORT).show()

            }else{
                val updatedEmp = currentEmploye!!.copy(
                    EmpName = name,
                    EmpEmail = email,
                    EmpAddress = address,
                    EmpPhone = phone,
                    EmpRole = role
                )
                employeviewmodel.updateEmp(updatedEmp)
                Toast.makeText(requireContext(), "Employee updated", Toast.LENGTH_SHORT).show()
            }
            findNavController().navigate(R.id.action_addEmployeFragment_to_homeFragment)
        }
    }
}