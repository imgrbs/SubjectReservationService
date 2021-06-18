package com.sit.course.opencoursereservation.subject_reservation;

import com.sit.course.opencoursereservation.user.model.User;
import com.sit.course.opencoursereservation.subject_reservation.service.SubjectReservationService;
import com.sit.course.opencoursereservation.user.repository.UserRepository;
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

        Mockito.when(userRepository.findUserById(1L)).thenReturn(user);
        Mockito.spy(subjectReservationService).reserveSubject(subjectId, user);

        underTest.reserveSubject(subjectId);
    }
}