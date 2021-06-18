package com.sit.course.opencoursereservation.subject_reservation.service;

import com.sit.course.opencoursereservation.user.model.User;

public interface SubjectReservationService {
    /**
     * Reserves subject by user.
     *
     * @param subjectId
     * @param user
     */
    void reserveSubject(String subjectId, User user);
}
