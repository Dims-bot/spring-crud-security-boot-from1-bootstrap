package com.javamentor.springcrudsecuritybootfrom1.repository;

import com.javamentor.springcrudsecuritybootfrom1.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class RepositoryImpl {





    @PersistenceContext
    private EntityManager em;

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RepositoryImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //public List<User> getAllUsers() {
   //     return userRepository.findAll();
  //  }

    public List<User> getAllUsers()  {
        List<User>  users = userRepository.getAllUsers();
        return users;
    }

    public User getUserById(Long id) {

        User user = userRepository.getOne(id);

        return user;
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateUser(Long id, User updatedUser) {
        User userToBeUpdated = userRepository.getOne(id);

        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setUsername(updatedUser.getUsername());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

        userRepository.save(userToBeUpdated);

    }



}
