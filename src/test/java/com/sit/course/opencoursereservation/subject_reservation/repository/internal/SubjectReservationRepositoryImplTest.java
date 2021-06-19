package com.sit.course.opencoursereservation.subject_reservation.repository.internal;

import com.sit.course.opencoursereservation.exception.DuplicateEntityException;
import com.sit.course.opencoursereservation.subject_reservation.model.Subject;
import com.sit.course.opencoursereservation.subject_reservation.model.SubjectReservation;
import com.sit.course.opencoursereservation.user.model.User;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SubjectReservationRepositoryImplTest {
    private SubjectReservationRepositoryImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new SubjectReservationRepositoryImpl();
    }

    @Test
    void testSaveWithNotDuplicate() {
        Subject subject = Mockito.mock(Subject.class);
        User user = Mockito.mock(User.class);
        SubjectReservation subjectReservation = new SubjectReservation(subject, user);

        underTest.save(subjectReservation);

        MatcherAssert.assertThat(subjectReservation.getId(), CoreMatchers.equalTo(1L));
        MatcherAssert.assertThat(subjectReservation.getSubject(), CoreMatchers.equalTo(subject));
        MatcherAssert.assertThat(subjectReservation.getUser(), CoreMatchers.equalTo(user));
    }

    @Test
    void testSaveWithDuplicateEntity() {
        Subject subject = Mockito.mock(Subject.class);
        User user = Mockito.mock(User.class);
        SubjectReservation subjectReservation = new SubjectReservation(1, subject, user);

        underTest.save(subjectReservation);

        Assertions.assertThrows(DuplicateEntityException.class, () -> underTest.save(subjectReservation));
    }
}