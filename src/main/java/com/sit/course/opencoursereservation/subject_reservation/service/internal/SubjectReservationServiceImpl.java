package com.sit.course.opencoursereservation.subject_reservation.service.internal;

import com.sit.course.opencoursereservation.subject_reservation.model.Subject;
import com.sit.course.opencoursereservation.subject_reservation.model.SubjectReservation;
import com.sit.course.opencoursereservation.subject_reservation.repository.SubjectReservationRepository;
import com.sit.course.opencoursereservation.subject_reservation.service.OutOfQuotaException;
import com.sit.course.opencoursereservation.user.model.User;
import com.sit.course.opencoursereservation.subject_reservation.repository.SubjectRepository;
import com.sit.course.opencoursereservation.subject_reservation.service.SubjectReservationService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Service
public class SubjectReservationServiceImpl implements SubjectReservationService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectReservationRepository subjectReservationRepository;

    @Override
    public void reserveSubject(String subjectId, User user) {
        Subject subject = subjectRepository.findBySubjectId(subjectId);

        if (subject.getCurrentStudentNumber() == subject.getQuota()) {
            throw new OutOfQuotaException();
        }

        int currentStudentNumber = subject.getCurrentStudentNumber() + 1;
        subject.setCurrentStudentNumber(currentStudentNumber);

        subjectReservationRepository.save(new SubjectReservation(subject, user));
    }
}
