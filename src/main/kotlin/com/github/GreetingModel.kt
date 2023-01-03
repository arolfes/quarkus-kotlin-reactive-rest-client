package com.github

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class GreetingModel(
    @field:JsonProperty("firstName")
    val firstName: String,
    @field:JsonProperty("lastName")
    val lastName: String
)