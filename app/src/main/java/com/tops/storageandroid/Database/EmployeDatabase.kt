package com.tops.storageandroid.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tops.storageandroid.Dao.EmployeDao
import com.tops.storageandroid.Entity.Employe

@Database([Employe::class], version = 1)
abstract class EmployeDatabase: RoomDatabase() {

    abstract fun employeDao() : EmployeDao
}