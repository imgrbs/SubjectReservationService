package com.sit.course.opencoursereservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "create duplicate entity failed")
public class DuplicateEntityException extends RuntimeException {
}
