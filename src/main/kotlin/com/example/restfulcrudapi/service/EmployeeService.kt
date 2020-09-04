package com.example.restfulcrudapi.service

import com.example.restfulcrudapi.entity.Employee

interface EmployeeService {

    fun findAll(): List<Employee>

    fun findById(id: Int): Employee

    fun save(employee: Employee)

    fun deleteById(id: Int)
}