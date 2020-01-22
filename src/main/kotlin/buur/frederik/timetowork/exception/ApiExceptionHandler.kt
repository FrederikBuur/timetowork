package buur.frederik.timetowork.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.ZoneId
import java.time.ZonedDateTime


@ControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {
	
	@ExceptionHandler(value = [ApiRequestException::class])
	fun handleApiRequestException(e: ApiRequestException): ResponseEntity<Any> {
		return ApiResponseException(
				message = e.message,
				httpStatus = e.httpStatus,
				statusCode = e.httpStatus.value(),
				timestamp = ZonedDateTime.now(ZoneId.of("Z"))
		).let { exception ->
			ResponseEntity(exception, e.httpStatus)
		}
	}
	
	
}