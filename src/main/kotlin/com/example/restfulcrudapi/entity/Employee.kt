package com.example.restfulcrudapi.entity

import javax.persistence.*
import javax.persistence.Entity


@Entity
@Table(name = "employee")
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int = 0

    @Column(name = "first_name")
    var firstName: String = ""

    @Column(name = "last_name")
    var lastName: String = ""

    @Column(name = "email")
    var email: String = ""

    // Define constructors
    constructor() {}

    constructor(firstName: String, lastName: String, email: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

    // Define toString()
    override fun toString(): String {
        return "Entity(id=$id, firstName='$firstName', lastName='$lastName', email='$email')"
    }
}