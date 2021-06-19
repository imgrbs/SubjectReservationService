package com.sit.course.opencoursereservation.subject_reservation.service.internal;

import com.sit.course.opencoursereservation.subject_reservation.model.Subject;
import com.sit.course.opencoursereservation.subject_reservation.model.SubjectReservation;
import com.sit.course.opencoursereservation.subject_reservation.repository.SubjectRepository;
import com.sit.course.opencoursereservation.subject_reservation.repository.SubjectReservationRepository;
import com.sit.course.opencoursereservation.subject_reservation.service.OutOfQuotaException;
import com.sit.course.opencoursereservation.user.model.User;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class SubjectReservationServiceImplTest {
    private SubjectReservationServiceImpl underTest;

    private SubjectRepository subjectRepository;
    private SubjectReservationRepository subjectReservationRepository;

    private String subjectId = "dotnet";
    private User user = new User(1L);

    @BeforeEach
    void setUp() {
        underTest = new SubjectReservationServiceImpl();

        subjectRepository = Mockito.mock(SubjectRepository.class);
        underTest.setSubjectRepository(subjectRepository);

        subjectReservationRepository = Mockito.mock(SubjectReservationRepository.class);
        underTest.setSubjectReservationRepository(subjectReservationRepository);
    }

    @Test
    void reserveSubjectWithAcceptableQuota() {
        Subject subject = createSubject(3);

        Mockito.when(subjectRepository.findBySubjectId(subjectId)).thenReturn(subject);
        Mockito.spy(subjectReservationRepository).save(Mockito.any(SubjectReservation.class));

        underTest.reserveSubject(subjectId, user);

        MatcherAssert.assertThat(subject.getCurrentStudentNumber(), CoreMatchers.equalTo(4));
    }

    @Test
    void reserveSubjectWithExceedQuota() {
        Subject subject = createSubject(10);

        Mockito.when(subjectRepository.findBySubjectId(subjectId)).thenReturn(subject);

        Assertions.assertThrows(OutOfQuotaException.class, () -> underTest.reserveSubject(subjectId, user));
        MatcherAssert.assertThat(subject.getCurrentStudentNumber(), CoreMatchers.equalTo(10));
    }

    private Subject createSubject(int currentStudentNumber) {
        Subject subject = new Subject();
        subject.setQuota(10);
        subject.setCurrentStudentNumber(currentStudentNumber);
        return subject;
    }
}