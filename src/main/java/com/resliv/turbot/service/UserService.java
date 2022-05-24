package com.resliv.turbot.service;

import com.resliv.turbot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
    User create(User user);
    void delete(User user);
}
