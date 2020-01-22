package buur.frederik.timetowork.exception

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

class ApiRequestException constructor(
		override val message: String,
		val httpStatus: HttpStatus) : RuntimeException(message) {

	
}