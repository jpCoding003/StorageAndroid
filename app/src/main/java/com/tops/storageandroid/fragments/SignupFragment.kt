package com.tops.storageandroid.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tops.storageandroid.R
import com.tops.storageandroid.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnsignup.setOnClickListener {
          if (checkvalid()){
              activity?.supportFragmentManager?.commit {
                  setReorderingAllowed(true)
                  replace<LoginFragment>(R.id.mainactivitycontainer)
              }
              Toast.makeText(requireContext(), " Successfully SignUp", Toast.LENGTH_SHORT).show()
          }else{
              Toast.makeText(requireContext(), " Enter Valid Details!!", Toast.LENGTH_SHORT).show()
          }
        }

        binding.btnlogin.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                replace<LoginFragment>(R.id.mainactivitycontainer)
            }
        }
    }

   // val email = binding.etEmail.text.toString()
    public fun checkvalid(): Boolean{
        if (binding.etFirst.text.toString() == ""){
            binding.etFirst.setError(" *Require")
            return false
        }else if (binding.etLastname.text.toString() == ""){
            binding.etLastname.setError(" *Require ")
            return false
        }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()){
            binding.etEmail.setError(" *Enter Valid ID ")
            return false
        }else if (binding.etUsername.text.toString() == ""){
            binding.etUsername.setError(" *Require ")
            return false
        }else if (binding.etPassword.text.toString().length < 8){
            binding.etPassword.setError(" *Require ")
            return false
        }else {
            return true
        }
    }
}