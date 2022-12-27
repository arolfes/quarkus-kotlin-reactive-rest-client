package com.github

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
@QuarkusTestResource(WireMockExtensions::class)
class GreetingResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .`when`().get("/hello")
            .then()
            .statusCode(200)
            .body(`is`("Hello Kotlin Quarkus Supersonic Subatomic Framework User"))
    }

    @Test
    fun testHelloEndpoint_WithFooBar() {
        given()
            .`when`().get("/hello?firstName=Foo&lastName=Bar")
            .then()
            .statusCode(200)
            .body(`is`("Hello Foo Bar Supersonic Subatomic Framework User"))
    }
}