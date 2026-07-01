package com.astronova.user.service;

import com.astronova.user.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findByEmail(String email);

}
