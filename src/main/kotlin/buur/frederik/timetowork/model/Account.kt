package buur.frederik.timetowork.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.validation.constraints.NotBlank

class Account(
        @JsonProperty("id")
        val id: UUID,
        @JsonProperty("username")
        @get: NotBlank(message = "username is required")
        val username: String,
        @JsonProperty("password")
        @get: NotBlank(message = "password is required")
        val password: String
) {
}