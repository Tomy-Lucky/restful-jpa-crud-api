package com.example.restfulcrudapi.dao

import com.example.restfulcrudapi.entity.Employee

interface EmployeeDao {

    fun findAll(): List<Employee>

    fun findById(id: Int): Employee

    fun save(employee: Employee)

    fun deleteById(id: Int)
}