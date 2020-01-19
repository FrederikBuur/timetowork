package buur.frederik.timetowork.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.validation.constraints.NotBlank

class User(
        @JsonProperty("id")
        val id: UUID,
        @JsonProperty("first_name")
        @get: NotBlank(message = "first name is required")
        val firstName: String,
        @JsonProperty("last_name")
        @get: NotBlank(message = "last name is required")
        val lastName: String,
        @JsonProperty("image_url")
        val imageUrl: String?
)