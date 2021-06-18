package com.sit.course.opencoursereservation.subject_reservation.repository;

import com.sit.course.opencoursereservation.subject_reservation.model.Subject;

public interface SubjectReservationRepository {
    /**
     * Finds subject by subject id.
     *
     * @param subjectId
     * @return subject
     */
    Subject findBySubjectId(String subjectId);
}
