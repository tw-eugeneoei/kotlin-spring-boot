package com.kotlinspringboot.controllers

import com.kotlinspringboot.services.GreetingService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings") // any endpoints build under this class will have this base class
class GreetingController(val greetingService: GreetingService) {

    companion object : KLogging()

    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable("name") name: String): String {
        logger.info("name param is $name")
        return greetingService.getGreeting(name)
    }
}