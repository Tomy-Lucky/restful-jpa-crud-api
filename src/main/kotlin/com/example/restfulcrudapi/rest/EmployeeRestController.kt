package com.example.restfulcrudapi.rest

import com.example.restfulcrudapi.entity.Employee
import com.example.restfulcrudapi.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("/api")
class EmployeeRestController
@Autowired
constructor(
        private val employeeService: EmployeeService
) {

    @GetMapping("/employees")
    fun findAll(): List<Employee> {
        return employeeService.findAll()
    }

    // add mapping for Get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    fun getEmployeeById(@PathVariable employeeId: Int): Employee {

        val employee: Employee = employeeService.findById(employeeId)
        if (employee == null) {
            throw RuntimeException("Employee id not found - $employeeId")
        }
        return employee
    }

    // add mapping for POST /employees/
    @PostMapping("/employees")
    fun addEmployee(@RequestBody employee: Employee): Employee {

        // setting id to 0
        // this will save new item instead of updating

        employee.id = 0
        employeeService.save(employee)
        return employee
    }

    // add mapping for PUT /employees - updating data of existing employee
    @PutMapping("/employees")
    fun updateEmployee(@RequestBody employee: Employee): Employee {

        employeeService.save(employee)
        return employee
    }

    // add mapping for DELETE /employees/{employeeId}
    @DeleteMapping("employees/{employeeId}")
    fun deleteEmployee(@PathVariable employeeId: Int): String {

        val employee: Employee = employeeService.findById(employeeId)
        if (employee == null) {
            throw RuntimeException("Employee id not found - $employeeId")
        }
        employeeService.deleteById(employeeId)
        return "Deleted employee id - $employeeId"
    }
}