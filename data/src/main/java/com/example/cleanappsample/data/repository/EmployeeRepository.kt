package com.example.cleanappsample.data.repository

import androidx.lifecycle.LiveData
import com.example.cleanappsample.data.EmployeeDao
import com.example.cleanappsample.Employee

class EmployeeRepository(private val employeeDao: EmployeeDao) {


    val readAlltheData:LiveData<List<Employee>> = employeeDao.getAllEmployee()
    suspend fun addEmployee(employee: Employee){

        employeeDao.addEmployee(employee)
    }

}