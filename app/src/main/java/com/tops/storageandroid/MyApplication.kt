package com.tops.storageandroid

import android.app.Application
import androidx.room.Room
import com.tops.storageandroid.Database.EmployeDatabase

class MyApplication : Application() {

    companion object{

        lateinit var  employes: EmployeDatabase
    }

    override fun onCreate() {
        super.onCreate()
        employes = Room.databaseBuilder(applicationContext, EmployeDatabase::class.java,"employedatabase").build()
    }
}