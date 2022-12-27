package com.github

import com.fasterxml.jackson.annotation.JsonProperty

data class GreetingModel(
    @field:JsonProperty("firstName")
    val firstName: String,
    @field:JsonProperty("lastName")
    val lastName: String
)