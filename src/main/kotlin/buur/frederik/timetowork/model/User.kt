package buur.frederik.timetowork.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class User(
        @JsonProperty("id") val id: UUID?,
        @JsonProperty("name") val name: String
)