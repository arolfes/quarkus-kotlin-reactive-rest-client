package com.github

import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.logging.Logger
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource(
    @RestClient val greetingRestClient: GreetingRestClient
) {

    private val log = Logger.getLogger(GreetingResource::class.java)

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(
        @QueryParam("firstName") firstName: String?,
        @QueryParam("lastName") lastName: String?
    ) : String {
        log.info("firstName=$firstName, lastName=$lastName")
        val greetingModel = GreetingModel(firstName?:"Kotlin", lastName?:"Quarkus")
        log.info("greetingModel=$greetingModel")
        val result = greetingRestClient.greetUser(greetingModel)
        log.info("greetingResult=$result")
        return result
    }
}