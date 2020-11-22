package com.example.cleanappsample

import android.text.Editable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_table")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String, val designation: String, val salary:Int)