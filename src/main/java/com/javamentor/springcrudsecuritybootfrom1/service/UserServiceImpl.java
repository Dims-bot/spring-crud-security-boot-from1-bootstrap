package com.javamentor.springcrudsecuritybootfrom1.service;

import com.javamentor.springcrudsecuritybootfrom1.Model.Role;
import com.javamentor.springcrudsecuritybootfrom1.Model.User;
import com.javamentor.springcrudsecuritybootfrom1.repository.RepositoryImpl;
import com.javamentor.springcrudsecuritybootfrom1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    RepositoryImpl repositoryImpl;

    @Autowired
    public UserServiceImpl(RepositoryImpl repositoryImpl) {
        this.repositoryImpl = repositoryImpl;
    }

    public List<User> getAllUsers() {
        return repositoryImpl.getAllUsers();
    }

    @Override
    public User getUserById(Long id) { return repositoryImpl.getUserById(id);}

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    @Transactional
    public void save(User user) { repositoryImpl.save(user); }

    @Override
    @Transactional
    public void updateUser(Long id, User updatedUser) { repositoryImpl.updateUser(id, updatedUser);}

    @Override
    public void deleteUser(Long id) {

    }


//    private final UserRepository userRepository;
//    //private final RoleRepository roleRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository,
//                       //RoleRepository roleRepository,
//                       BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        //this.roleRepository = roleRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public User getUserById(Long id) {
//        return userRepository.getOne(id);
//    }
//
//    public User findUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode((user.getPassword())));
////        Role userRole = roleRepository.findByRole("ADMIN");
////        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public void updateUser(Long id, User updatedUser) {
//        User userToBeUpdated = userRepository.getOne(id);
//
//        userToBeUpdated.setFirstName(updatedUser.getFirstName());
//        userToBeUpdated.setUsername(updatedUser.getUsername());
//        userToBeUpdated.setLastName(updatedUser.getLastName());
//        userToBeUpdated.setAge(updatedUser.getAge());
//        userToBeUpdated.setPassword(updatedUser.getPassword());
//
//        userRepository.save(userToBeUpdated);
//
//    }



}
