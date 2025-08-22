package hr.tvz.hrsustav.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleExceptions(Exception e, WebRequest request) {
		if (e instanceof NoChangesToDbException e1) 	return handleNoChangesToDbException(e1);
		if (e instanceof NoEntriesFoundException e2) 	return handleNoEntriesFound(e2);
		else											return handleInternalException(e);
	}

	private ResponseEntity<String> handleNoChangesToDbException(NoChangesToDbException e){
		e.printStackTrace();
		return ResponseEntity.ok().body("No changes made to DB.");
	}

	private ResponseEntity<String> handleNoEntriesFound(NoEntriesFoundException e){
		e.printStackTrace();
		return ResponseEntity.ok().body("No entries found.");
	}

	private ResponseEntity<String> handleInternalException(Exception e){
		e.printStackTrace();
		return ResponseEntity.internalServerError().body("Uh-oh! Something went wrong.");
	}
}