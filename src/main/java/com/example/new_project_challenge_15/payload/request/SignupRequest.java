package com.example.new_project_challenge_15.payload.request;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.util.Set;

public class SignupRequest {
  @Size(min = 1, max = 50)
  private String username;

  @Size(max = 50)
  private String email;

  private Set<String> role;

  @Size(min = 1, max = 40)
  private String password;
  //  @NotBlank
  private String level;
  @Lob
  private String user_photo;

  public String getUser_photo() {
    return user_photo;
  }

  public void setUser_photo(String user_photo) {
    this.user_photo = user_photo;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }
}
