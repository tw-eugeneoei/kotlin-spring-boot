package com.kotlinspringboot.controllers

import com.kotlinspringboot.services.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings") // any endpoints build under this class will have this base class
class GreetingController(val greetingService: GreetingService) {

    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable("name") name: String): String {
        return greetingService.getGreeting(name)
    }
}