package com.sit.course.opencoursereservation.subject_reservation.repository.internal;

import com.sit.course.opencoursereservation.exception.DuplicateEntityException;
import com.sit.course.opencoursereservation.subject_reservation.model.SubjectReservation;
import com.sit.course.opencoursereservation.subject_reservation.repository.SubjectReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SubjectReservationRepositoryMemory implements SubjectReservationRepository {
    private Map<Long, SubjectReservation> subjectReservations = new HashMap<Long, SubjectReservation>();

    @Override
    public SubjectReservation save(SubjectReservation subjectReservation) {
        SubjectReservation currentReservation = subjectReservations.get(subjectReservation.getId());

        if (currentReservation != null) {
            throw new DuplicateEntityException();
        }

        long id = subjectReservations.size() + 1;
        subjectReservation.setId(id);

        return subjectReservations.put(id, subjectReservation);
    }
}
