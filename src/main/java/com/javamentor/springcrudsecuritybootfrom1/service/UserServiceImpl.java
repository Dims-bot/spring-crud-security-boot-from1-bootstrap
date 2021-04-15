package com.javamentor.springcrudsecuritybootfrom1.service;

import com.javamentor.springcrudsecuritybootfrom1.Model.User;
import com.javamentor.springcrudsecuritybootfrom1.repository.RepositoryImpl;
import com.javamentor.springcrudsecuritybootfrom1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private RepositoryImpl repositoryImpl;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(RepositoryImpl repositoryImpl, UserRepository userRepository) {
        this.repositoryImpl = repositoryImpl;
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return repositoryImpl.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return repositoryImpl.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> userFromDbByUserName = userRepository.findByUsername(username);

        return userFromDbByUserName.orElse(new User());
    }

    @Override
    @Transactional
    public void save(User user) {
        repositoryImpl.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User updatedUser) {
        repositoryImpl.updateUser(id, updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        repositoryImpl.deleteUser(id);

    }


}
