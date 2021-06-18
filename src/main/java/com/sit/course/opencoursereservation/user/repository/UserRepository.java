package com.sit.course.opencoursereservation.user.repository;

import com.sit.course.opencoursereservation.user.model.User;

public interface UserRepository {
    /**
     * Finds user by user userId.
     *
     * @param userId
     * @return user
     */
    User findUserById(long userId);
}
