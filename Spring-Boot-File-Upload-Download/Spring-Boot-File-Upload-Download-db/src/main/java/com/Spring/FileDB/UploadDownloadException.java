package com.Spring.FileDB;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;



@ControllerAdvice
public class UploadDownloadException {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<UploadDownloadResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new UploadDownloadResponseMessage("File too large!"));
	}
}


