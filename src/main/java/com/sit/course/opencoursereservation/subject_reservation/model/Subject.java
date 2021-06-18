package com.sit.course.opencoursereservation.subject_reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private String subjectId;
    private int quota;
    private int currentStudentNumber;

    public Subject(String subjectId) {
        this.subjectId = subjectId;
        this.quota = 30;
        this.currentStudentNumber = 0;
    }
}
