package maria.anikina.controller;

import maria.anikina.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
@RequestMapping("/")
public class ErrorHandler {
	@ExceptionHandler(PersonNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@GetMapping()
	public String handleValidationError() {
		return "exception";
	}
}
