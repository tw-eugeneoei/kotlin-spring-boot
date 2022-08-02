package com.kotlinspringboot.controllers

import com.kotlinspringboot.dto.CourseDto
import com.kotlinspringboot.services.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/courses")
class CoursesController(val courseService: CourseService) {

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody parses request body and maps it to CourseDTO
    fun create(@RequestBody course: CourseDto): CourseDto {
        return courseService.create(course)
    }
}