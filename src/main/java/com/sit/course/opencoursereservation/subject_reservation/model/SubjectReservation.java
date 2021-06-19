package com.sit.course.opencoursereservation.subject_reservation.model;

import com.sit.course.opencoursereservation.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectReservation {
    private long id;
    private Subject subject;
    private User user;

    public SubjectReservation(Subject subject, User user) {
        this.subject = subject;
        this.user = user;
    }
}
