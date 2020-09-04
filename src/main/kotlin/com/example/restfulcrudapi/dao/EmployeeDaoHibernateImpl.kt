package com.example.restfulcrudapi.dao

import com.example.restfulcrudapi.entity.Employee
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class EmployeeDaoHibernateImpl // set up constructor injection
@Autowired constructor(private var entityManager: EntityManager) : EmployeeDao {

    override fun findAll(): List<Employee> {

        // get current hibernate session
        val currentSession: Session = entityManager.unwrap(Session::class.java)

        // create query
        val query: Query<Employee> = currentSession.createQuery("from Employee", Employee::class.java)

        // execute query and get results
        val employees: List<Employee> = query.resultList

        // return the results
        return employees
    }

    override fun findById(id: Int): Employee {

        // get current hibernate session
        val currentSession: Session = entityManager.unwrap(Session::class.java)

        // get the employee
        val employee: Employee = currentSession.get(Employee::class.java, id)

        // return the result
        return employee
    }

    override fun save(employee: Employee) {

        // get current hibernate session
        val currentSession: Session = entityManager.unwrap(Session::class.java)

        // saveOrUpdate employee(if id = 0 -> insert/save else update)
        currentSession.saveOrUpdate(employee)
    }

    override fun deleteById(id: Int) {

        // get current hibernate session
        val currentSession: Session = entityManager.unwrap(Session::class.java)

        // delete employee by id(primary key)
        val query = currentSession.createQuery("delete from Employee where id=:employeeId")
                .setParameter("employeeId", id)
                .executeUpdate()
    }
}