package com.sit.course.opencoursereservation.subject_reservation.repository;

import com.sit.course.opencoursereservation.subject_reservation.model.SubjectReservation;

public interface SubjectReservationRepository {
    /**
     * Saves a new subject reservation.
     *
     * @param subjectReservation
     * @return success subject reservation
     */
    SubjectReservation save(SubjectReservation subjectReservation);
}
