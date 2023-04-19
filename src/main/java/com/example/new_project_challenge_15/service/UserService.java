//package com.example.new_project_challenge_15.service;
//
//import com.example.new_project_challenge_15.entity.User;
//import com.example.new_project_challenge_15.entity.enums.Role;
//import com.example.new_project_challenge_15.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public boolean createUser(User user) {
//        user.setActive(true);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Set<Role> rolee = new HashSet<>();
//        rolee.add(Role.ROLE_USER);
//        user.setRoles(rolee);
//        user.setDateOfCreated(LocalDateTime.now());
//        userRepository.save(user);
//        return true;
//    }
//    public List<User> list(){
//       return userRepository.findAll();
//    }
//
//}
