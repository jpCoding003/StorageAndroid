package com.tops.storageandroid.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tops.storageandroid.Entity.Employe
import com.tops.storageandroid.databinding.ItemEmployeBinding

class MyAdapter(var employeList: MutableList<Employe>,
                private val onDeleteClick: (Employe) -> Unit,
                private val onItemClick: (Employe) -> Unit): RecyclerView.Adapter<MyAdapter.EmployeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeViewHolder {
        val binding = ItemEmployeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EmployeViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: EmployeViewHolder,
        position: Int
    ) {

        val emplist = employeList[position]
        holder.binding.tvEmpName.text = emplist.EmpName
        holder.binding.tvEmpRole.text = emplist.EmpRole

        holder.binding.btnDelete.setOnClickListener {
            onDeleteClick(emplist)
        }

        holder.binding.root.setOnClickListener {
            onItemClick(emplist)
        }

    }

    override fun getItemCount(): Int = employeList.size


    fun updateList(newlist: MutableList<Employe>){
        employeList = newlist
        notifyDataSetChanged()
    }

    class EmployeViewHolder(val binding : ItemEmployeBinding): RecyclerView.ViewHolder(binding.root)


}