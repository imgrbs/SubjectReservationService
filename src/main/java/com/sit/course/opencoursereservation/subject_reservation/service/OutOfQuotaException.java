package com.sit.course.opencoursereservation.subject_reservation.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "this subject is out of quota")
public class OutOfQuotaException extends RuntimeException {
}
