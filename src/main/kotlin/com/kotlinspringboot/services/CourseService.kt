package com.kotlinspringboot.services

import com.kotlinspringboot.dto.CourseDto
import com.kotlinspringboot.entity.Course
import com.kotlinspringboot.repositories.CourseRepository
import mu.KLogger
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object : KLogging()

    fun create(course: CourseDto): CourseDto {
        val entity = course.let {
            Course(
                null,
                it.name,
                it.category
            )
        }
        // save expects an Entity type therefore need to convert from DTO type to Entity type
        courseRepository.save(entity)
        logger.info("Saved course: $entity")
        return entity.let {
            CourseDto(
                it.id,
                it.name,
                it.category
            )
        }
    }
}