package com.github

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager

class WireMockExtensions : QuarkusTestResourceLifecycleManager {

    private lateinit var wireMockServer: WireMockServer

    override fun start(): MutableMap<String, String> {
        wireMockServer = WireMockServer()
        wireMockServer.start()

        wireMockServer.stubFor(
            WireMock.post(
                WireMock.urlEqualTo("/greeting")
            ).withRequestBody(
                WireMock.equalToJson(
                    """{
                                 "firstName": "Kotlin",
                                 "lastName": "Quarkus"
                             }"""
                )
            ).willReturn(
                WireMock.aResponse()
                    .withHeader("Content-Type", "application/json")
                    .withBody("""Hello Kotlin Quarkus Supersonic Subatomic Framework User""")
            )
        )

        wireMockServer.stubFor(
            WireMock.post(
                WireMock.urlEqualTo("/greeting")
            ).withRequestBody(
                WireMock.equalToJson(
                    """{
                                 "firstName": "Foo",
                                 "lastName": "Bar"
                             }"""
                )
            ).willReturn(
                WireMock.aResponse()
                    .withHeader("Content-Type", "application/json")
                    .withBody("""Hello Foo Bar Supersonic Subatomic Framework User""")
            )
        )

        return mutableMapOf("""quarkus.rest-client."com.github.GreetingRestClient".url""" to wireMockServer.baseUrl())
    }

    override fun stop() {
        wireMockServer?.stop()
    }

}