package buur.frederik.timetowork.exception

import org.springframework.http.HttpStatus
import java.time.ZonedDateTime

data class ApiResponseException(
		val message: String,
		val httpStatus: HttpStatus,
		val statusCode: Int,
		val timestamp: ZonedDateTime
)