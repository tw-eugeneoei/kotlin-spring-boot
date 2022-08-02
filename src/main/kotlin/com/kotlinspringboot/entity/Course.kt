package com.kotlinspringboot.entity

import javax.persistence.*

// hold data for representing entity object to process data into the DB
@Entity
@Table(name = "Courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // annotations above make id column an auto generated sequence column
    val id: Int?,
    val name: String,
    val category: String
)