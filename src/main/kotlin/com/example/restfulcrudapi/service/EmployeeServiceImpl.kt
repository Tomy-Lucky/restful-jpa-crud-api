package com.example.restfulcrudapi.service

import com.example.restfulcrudapi.dao.EmployeeDao
import com.example.restfulcrudapi.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeServiceImpl
@Autowired
constructor(
        // define main DaoImpl
        @Qualifier("employeeDaoJpaImpl") // name of class should be lower case
        private val employeeDao: EmployeeDao
) : EmployeeService {

    @Transactional
    override fun findAll(): List<Employee> {
        return employeeDao.findAll()
    }

    @Transactional
    override fun findById(id: Int): Employee {
        return employeeDao.findById(id)
    }

    @Transactional
    override fun save(employee: Employee) {
        employeeDao.save(employee)
    }

    @Transactional
    override fun deleteById(id: Int) {
        employeeDao.deleteById(id)
    }
}