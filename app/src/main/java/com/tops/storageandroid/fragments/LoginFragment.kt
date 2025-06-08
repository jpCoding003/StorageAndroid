package com.tops.storageandroid.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tops.storageandroid.DrawerDashboard
import com.tops.storageandroid.R
import com.tops.storageandroid.databinding.FragmentLoginBinding

val IS_LOGIN = "IS_LOGIN"
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnlogin.setOnClickListener {
//            val sharepref = activity?.getSharedPreferences(
//                getString(R.string.app_name),
//                Context.MODE_PRIVATE
//            ) ?: return@setOnClickListener
//            with(sharepref.edit()) {
//                putBoolean(IS_LOGIN, true)
//                apply()
//            }

//            if (binding.etusername.text.toString() == "") {
//                binding.tvusername.error = " *Username Required"
//                return@setOnClickListener
//            }
//            if (binding.etpassword.text.toString() == "" || binding.etpassword.length() < 8) {
//                binding.tvpassword.error = " *Required Min. 8 characters!!"
//                return@setOnClickListener
//            }
//            if (binding.etusername.text.toString()== "Jay"
//                && binding.etpassword.text.toString()== "Jay1234") {
            if (checkField()){
                val intent = Intent(context, DrawerDashboard::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(requireContext(), "Enter Valid Details!!", Toast.LENGTH_SHORT).show()

            }
        }

            binding.btnsignup.setOnClickListener {
                activity?.supportFragmentManager?.commit {
                    setReorderingAllowed(true)
                    replace<SignupFragment>(R.id.mainactivitycontainer)
                }
            }
        }
        fun checkField(): Boolean {

            if (binding.etusername.text.toString() == "") {
                binding.tvusername.error = " *Required"
                return false
            }
            if (binding.etpassword.text.toString() == "" || binding.etpassword.length() < 8) {
                binding.tvpassword.error = " *Required Min. 8 characters!!"
                return false
            }
            return true
        }
    }