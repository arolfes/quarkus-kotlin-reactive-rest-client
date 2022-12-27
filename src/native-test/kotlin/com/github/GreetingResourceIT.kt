package com.github

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusIntegrationTest

@QuarkusIntegrationTest
@QuarkusTestResource(WireMockExtensions::class)
class GreetingResourceIT : GreetingResourceTest()
