package com.tops.storageandroid.ViewMOdel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tops.storageandroid.Entity.Employe
import com.tops.storageandroid.MyApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeViewModel : ViewModel() {

    val employeData = MyApplication.employes.employeDao()

    val employes: LiveData<List<Employe>> = employeData.getAllEmp()

    fun addEmp(name: String,email: String,address: String,phone: Long,role: String){
        viewModelScope.launch(Dispatchers.IO) {
            val insert = Employe(
                EmpName = name,
                EmpAddress = address,
                EmpEmail = email,
                EmpPhone = phone,
                EmpRole = role
            )
            employeData.insertEmp(insert)
        }

    }

    fun updateEmp(employe: Employe) {
        viewModelScope.launch(Dispatchers.IO) {
            employeData.updateEmp(employe)
        }
    }

    fun deleteEmp(employe: Employe) {
        viewModelScope.launch(Dispatchers.IO) {
            employeData.deleteEmp(employe)
        }
    }

}