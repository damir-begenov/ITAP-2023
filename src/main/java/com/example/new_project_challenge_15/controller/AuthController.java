package com.example.new_project_challenge_15.controller;

import com.example.new_project_challenge_15.models.ERole;
import com.example.new_project_challenge_15.models.Role;
import com.example.new_project_challenge_15.models.User;
import com.example.new_project_challenge_15.payload.request.LoginRequest;
import com.example.new_project_challenge_15.payload.request.SignupRequest;
import com.example.new_project_challenge_15.payload.response.JwtResponse;
import com.example.new_project_challenge_15.payload.response.MessageResponse;
import com.example.new_project_challenge_15.repository.RoleRepository;
import com.example.new_project_challenge_15.repository.UserRepository;
import com.example.new_project_challenge_15.security.jwt.JwtUtils;
import com.example.new_project_challenge_15.security.services.UserDetailsImpl;
import com.example.new_project_challenge_15.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3000)
@RestController
@RequestMapping("/api/finpol/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;
  @Autowired

  UserDetailsServiceImpl userDetailsService;
  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());
    return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            roles));
  }
  @PutMapping("/changePassword")
  public void changePassword(@RequestParam String password,Principal principal){
//    System.out.println(userDetailsService.loadUserByUsernamek(principal));
    User user = userDetailsService.loadUserByUsernamek(principal);
    user.setPassword(encoder.encode(password));
    System.out.println(user.getUsername());
    System.out.println(user.getEmail());
      userRepository.save(user);
  }
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest,@RequestParam("file") MultipartFile  file) {

    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
    }
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getEmail(),
            signUpRequest.getUsername(),
            encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
    ;

//    if (strRoles == null) {
//      Role userRole = roleRepository.findByName(ERole.ADMIN)
//          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//      roles.add(userRole);
//    } else {
//      strRoles.forEach(role -> {
//        switch (role) {
//        case "admin":
//          Role adminRole = roleRepository.findByName(ERole.ADMIN)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(adminRole);
//
//          break;
//        case "mod":
//          Role modRole = roleRepository.findByName(ERole.VIP)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(modRole);
//
//          break;
//        default:
//          Role userRole = roleRepository.findByName(ERole.LEVEL_3_USER)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(userRole);
//        }
//      });
//    }

    if (signUpRequest.getLevel().equals("2")) {
      Role userRole = roleRepository.findByName(ERole.LEVEL_2_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);  }
    if (signUpRequest.getLevel().equals("1")) {
      Role userRole = roleRepository.findByName(ERole.LEVEL_1_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);  }if (signUpRequest.getLevel().equals("3")) {
      Role userRole = roleRepository.findByName(ERole.LEVEL_3_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);  }if (signUpRequest.getLevel().equals("vip")) {
      Role userRole = roleRepository.findByName(ERole.VIP)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);  }if (signUpRequest.getLevel().equals("admin")) {
      Role userRole = roleRepository.findByName(ERole.ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);  }
    user.setActive(true);
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    if(fileName.contains(".."))
    {
      System.out.println("not a a valid file");
    }
    try {
      user.setUser_photo(Base64.getEncoder().encodeToString(file.getBytes()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    user.setRoles(roles);
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
