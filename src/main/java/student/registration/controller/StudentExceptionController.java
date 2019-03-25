package student.registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import student.registration.exceptionhandler.StudentNotFoundException;
import student.registration.model.StudentErrorResponse;

@ControllerAdvice
public class StudentExceptionController {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> exception(StudentNotFoundException e) {
		StudentErrorResponse err = new StudentErrorResponse();
		err.setStatusCode(HttpStatus.NOT_FOUND.value());
		err.setMessage(e.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(err,HttpStatus.NOT_FOUND);
		
	}
}
