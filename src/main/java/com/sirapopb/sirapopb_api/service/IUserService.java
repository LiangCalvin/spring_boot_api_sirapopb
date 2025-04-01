package com.sirapopb.sirapopb_api.service;

import com.sirapopb.sirapopb_api.entity.User;

import java.util.List;

public interface IUserService {

    User save(User user);
    List<User> getAll();
    User getUserById(Integer id);
    void deleteById(Integer id);
    void updateById(Integer id, User newUser);
}
