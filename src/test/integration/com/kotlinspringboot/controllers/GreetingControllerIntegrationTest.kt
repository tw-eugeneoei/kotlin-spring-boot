package com.kotlinspringboot.controllers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

// spin up test application in a random port instead of the default 8080
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// set profile name which can then match to respective profile's application yml file
@ActiveProfiles("test")
// provides a REST client to interact with endpoints
// will scan controllers and identify all endpoints and make them available to WebTestClient instance
// will also automatically detect port number service is running
@AutoConfigureWebTestClient
class GreetingControllerIntegrationTest {

    @Autowired
    // lateinit => allow value to be initialised by framework
    lateinit var webTestClient: WebTestClient

    @Test
    fun retrieveGreeting() {
        val name = "jon"
        val expected = "Hello $name from greeting service, Hello from default profile"

        val result = webTestClient
            .get()
            .uri("/v1/greetings/$name")
            .exchange() // initialise request to uri declared
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals(expected, result)
    }
}