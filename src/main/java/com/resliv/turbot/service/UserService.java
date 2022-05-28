package com.resliv.turbot.service;

import com.resliv.turbot.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByChatId(Long id);

    User create(User user);

    void delete(User user);
}
