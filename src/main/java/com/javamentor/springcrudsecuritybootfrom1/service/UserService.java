package com.javamentor.springcrudsecuritybootfrom1.service;

import com.javamentor.springcrudsecuritybootfrom1.Model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(Long id);

    public User getUserByUsername(String username);

    public void save(User user);

    public void updateUser(Long id, User updatedUser);

    public void deleteUser(Long id);
}
