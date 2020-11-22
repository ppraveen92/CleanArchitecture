package com.example.cleanappsample.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanappsample.Employee
import com.example.cleanappsample.EmployeeDatabase
import com.example.cleanappsample.data.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class EmployeeViewModel(application: Application) :AndroidViewModel(application) {
     val allEmployee:LiveData<List<Employee>>
    private val repository : EmployeeRepository

    init {
        val employeeDao = EmployeeDatabase.getDatabase(application).employeeDao()
        repository = EmployeeRepository(employeeDao)
        allEmployee =repository.readAlltheData
    }

    fun getAllEmployee(employee: Employee){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addEmployee(employee)
        }
    }

}