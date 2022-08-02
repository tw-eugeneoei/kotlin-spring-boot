package com.kotlinspringboot.services

import org.springframework.stereotype.Service

@Service
class GreetingService {
    fun getGreeting(name: String) = "Hello $name from greeting service"
}