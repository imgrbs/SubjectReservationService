package com.sit.course.opencoursereservation.user.repository.internal;

import com.sit.course.opencoursereservation.subject_reservation.exception.EntityNotFoundException;
import com.sit.course.opencoursereservation.user.model.User;
import com.sit.course.opencoursereservation.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryMemory implements UserRepository {
    private Map<Long, User> users = new HashMap<Long, User>();

    public UserRepositoryMemory() {
        for (long userId = 1; userId <= 10; userId++) {
            users.put(userId, new User(userId));
        }
    }

    @Override
    public User findUserById(long userId) {
        User user = users.get(userId);

        if (user == null) {
            throw new EntityNotFoundException();
        }

        return users.get(userId);
    }
}
