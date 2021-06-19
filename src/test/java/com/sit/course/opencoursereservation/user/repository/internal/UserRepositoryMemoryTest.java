package com.sit.course.opencoursereservation.user.repository.internal;

import com.sit.course.opencoursereservation.exception.EntityNotFoundException;
import com.sit.course.opencoursereservation.user.model.User;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryMemoryTest {
    private UserRepositoryMemory underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserRepositoryMemory();
    }

    @Test
    void testFindUserById() {
        User result = underTest.findUserById(1L);

        MatcherAssert.assertThat(result.getUserId(), CoreMatchers.equalTo(1L));
    }

    @Test
    void testFindUserByIdWithNotFound() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> underTest.findUserById(100L));
    }
}