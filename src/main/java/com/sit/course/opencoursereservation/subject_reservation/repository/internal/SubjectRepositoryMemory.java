package com.sit.course.opencoursereservation.subject_reservation.repository.internal;

import com.sit.course.opencoursereservation.exception.EntityNotFoundException;
import com.sit.course.opencoursereservation.subject_reservation.model.Subject;
import com.sit.course.opencoursereservation.subject_reservation.repository.SubjectRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SubjectRepositoryMemory implements SubjectRepository {
    private Map<String, Subject> subjects = new HashMap<String, Subject>();

    public SubjectRepositoryMemory() {
        subjects.put("dotnet", new Subject("dotnet"));
        subjects.put("maximum", new Subject("dotnet", 30, 30));
    }

    @Override
    public Subject findBySubjectId(String subjectId) {
        Subject subject = subjects.get(subjectId);

        if (subject == null) {
            throw new EntityNotFoundException();
        }

        return subject;
    }
}
