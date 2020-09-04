package com.example.restfulcrudapi.dao

import com.example.restfulcrudapi.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

import javax.persistence.Query

@Repository
class EmployeeDaoJpaImpl
@Autowired
constructor(
        private val entityManager: EntityManager
) : EmployeeDao {

    override fun findAll(): List<Employee> {

        // create query
        val query: Query = entityManager.createQuery("from Employee")

        // execute query and get result list
        val employees: List<Employee> = query.resultList as List<Employee>

        // return the results
        return employees
    }

    override fun findById(id: Int): Employee {
        val employee = entityManager.find(Employee::class.java, id)
        return employee
    }

    override fun save(employee: Employee) {
        val dbEmployee = entityManager.merge(employee)

        // update with id from DB ... so we can get generated id for save/insert
        employee.id = dbEmployee.id
    }

    override fun deleteById(id: Int) {
        val query = entityManager.createQuery("delete from Employee where id=:employeeId")
                .setParameter("employeeId", id)
                .executeUpdate()
    }
}