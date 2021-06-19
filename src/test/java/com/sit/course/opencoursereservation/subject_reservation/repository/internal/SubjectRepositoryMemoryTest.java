package com.sit.course.opencoursereservation.subject_reservation.repository.internal;

import com.sit.course.opencoursereservation.exception.EntityNotFoundException;
import com.sit.course.opencoursereservation.subject_reservation.model.Subject;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubjectRepositoryMemoryTest {

    private SubjectRepositoryMemory underTest;

    @BeforeEach
    void setUp() {
        underTest = new SubjectRepositoryMemory();
    }

    @Test
    void findBySubjectId() {
        String subjectId = "dotnet";

        Subject actual = underTest.findBySubjectId(subjectId);

        MatcherAssert.assertThat(actual.getSubjectId(), CoreMatchers.equalTo(subjectId));
        MatcherAssert.assertThat(actual.getQuota(), CoreMatchers.equalTo(30));
        MatcherAssert.assertThat(actual.getCurrentStudentNumber(), CoreMatchers.equalTo(0));
    }

    @Test
    void findBySubjectIdButNotFound() {
        String subjectId = "java";

        Assertions.assertThrows(EntityNotFoundException.class, () -> underTest.findBySubjectId(subjectId));
    }
}