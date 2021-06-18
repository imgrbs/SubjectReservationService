package com.sit.course.opencoursereservation.subject_reservation;

import com.sit.course.opencoursereservation.user.model.User;
import com.sit.course.opencoursereservation.subject_reservation.service.SubjectReservationService;
import com.sit.course.opencoursereservation.user.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Setter
@RestController
public class SubjectReservationController {
    @Autowired
    private SubjectReservationService subjectReservationService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/subject/{subjectId}/reserve")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void reserveSubject(@PathVariable String subjectId) {
        /*
         * This is a bad practice,
         * because it's should get from session or decoding from a jwt token.
         * then uses user id to find user from database.
         *
         * but we need quickly demo project.
         */
        User mockUser = userRepository.findUserById(1L);

        subjectReservationService.reserveSubject(subjectId, mockUser);
    }
}
