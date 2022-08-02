package com.kotlinspringboot.services

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingService {
    @Value("\${message}") // dynamically populate value from message property declared in application.yml
    lateinit var message: String
    fun getGreeting(name: String) = "Hello $name from greeting service, $message"
}