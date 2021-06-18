package com.sit.course.opencoursereservation.subject_reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "entity not found")
public class EntityNotFoundException extends RuntimeException {
}
