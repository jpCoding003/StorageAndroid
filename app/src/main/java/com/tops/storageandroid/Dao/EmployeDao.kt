package com.tops.storageandroid.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tops.storageandroid.Entity.Employe

@Dao
interface EmployeDao {

    @Query("SELECT * FROM EmployeDetails")
     fun getAllEmp(): LiveData<List<Employe>>

    @Insert
    suspend fun insertEmp(employe: Employe)


    @Update
    suspend fun updateEmp(employe: Employe)

    @Delete
    suspend fun deleteEmp(employe: Employe)
}