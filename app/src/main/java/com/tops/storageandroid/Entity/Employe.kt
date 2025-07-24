package com.tops.storageandroid.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity("EmployeDetails")
data class Employe(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name= "EmpName") val EmpName : String,

    @ColumnInfo(name= "EmpEmail") val EmpEmail : String,

    @ColumnInfo(name= "EmpAddress") val EmpAddress : String,

    @ColumnInfo(name= "EmpPhone") val EmpPhone : Long,

    @ColumnInfo(name= "EmpRole") val EmpRole : String,
): Serializable
