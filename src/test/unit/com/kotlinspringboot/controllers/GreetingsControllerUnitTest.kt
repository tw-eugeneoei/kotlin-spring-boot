package com.kotlinspringboot.controllers

import com.kotlinspringboot.services.GreetingService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [GreetingsController::class])
@AutoConfigureWebTestClient
class GreetingsControllerUnitTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var greetingServiceMock: GreetingService

    @Test
    fun retrieveGreeting() {
        val name = "jon"
        val expected = "Hello $name from greeting service, Hello from default profile"

        every { greetingServiceMock.getGreeting(any()) } returns expected

        val result = webTestClient
            .get()
            .uri("/v1/greetings/$name")
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals(expected, result)
    }
}