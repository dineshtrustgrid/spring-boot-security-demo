package com.spring.boot.security.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//RegisterRequest.java
public class RegisterPage {
 private String username;
 private String password;
 private String email;
 private String confirmPassword;

// // Getters and Setters
// public String getUsername() { return username; }
// public void setUsername(String username) { this.username = username; }
// 
// public String getPassword() { return password; }
// public void setPassword(String password) { this.password = password; }
// 
// public String getEmail() { return email; }
// public void setEmail(String email) { this.email = email; }
// 
// public String getConfirmPassword() { return confirmPassword; }
// public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}