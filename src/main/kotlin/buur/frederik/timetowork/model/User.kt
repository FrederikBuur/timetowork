package buur.frederik.timetowork.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.validation.constraints.NotBlank

class User(
        @JsonProperty("id")
        val id: UUID?,
        @JsonProperty("name")
        @get: NotBlank(message = "name is required")
        val name: String
)