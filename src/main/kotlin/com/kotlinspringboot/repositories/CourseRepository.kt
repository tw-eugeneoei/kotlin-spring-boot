package com.kotlinspringboot.repositories

import com.kotlinspringboot.entity.Course
import org.springframework.data.repository.CrudRepository

// CrudRepository gives you access to perform all CRUD operations on a specific entity
// Int refers to the auto generated column
interface CourseRepository : CrudRepository<Course, Int> {
}