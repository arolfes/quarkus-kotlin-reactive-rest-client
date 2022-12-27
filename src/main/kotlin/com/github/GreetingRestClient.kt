package com.github

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/greeting")
@RegisterRestClient
interface GreetingRestClient {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun greetUser(greeting: GreetingModel): String
}