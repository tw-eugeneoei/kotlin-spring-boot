package com.kotlinspringboot.entity

import javax.persistence.Entity
import javax.persistence.Table

// hold data for representing entity object to process data into the DB
@Entity
@Table(name = "Courses")
data class Course(
    val id: Int?,
    val name: String,
    val category: String
)