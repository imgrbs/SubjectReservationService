package com.sit.course.opencoursereservation.subject_reservation;

import com.sit.course.opencoursereservation.subject_reservation.model.Subject;
import com.sit.course.opencoursereservation.subject_reservation.model.SubjectReservation;
import com.sit.course.opencoursereservation.user.model.User;
import com.sit.course.opencoursereservation.subject_reservation.service.SubjectReservationService;
import com.sit.course.opencoursereservation.user.repository.UserRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SubjectReservationControllerTest {
    private SubjectReservationController underTest;

    private SubjectReservationService subjectReservationService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        underTest = new SubjectReservationController();

        subjectReservationService = Mockito.mock(SubjectReservationService.class);
        underTest.setSubjectReservationService(subjectReservationService);

        userRepository = Mockito.mock(UserRepository.class);
        underTest.setUserRepository(userRepository);
    }

    @Test
    void testReserveSubject() {
        String subjectId = "dotnet";
        User user = new User(1L);
        Subject subject = new Subject(subjectId);
        SubjectReservation expectReservation = new SubjectReservation(subject, user);

        Mockito.when(userRepository.findUserById(1L)).thenReturn(user);
        Mockito.when(subjectReservationService.reserveSubject(subjectId, user)).thenReturn(expectReservation);

        SubjectReservation result = underTest.reserveSubject(subjectId);

        MatcherAssert.assertThat(result.getUser(), CoreMatchers.equalTo(user));
        MatcherAssert.assertThat(result.getSubject().getSubjectId(), CoreMatchers.equalTo(subjectId));
    }
}