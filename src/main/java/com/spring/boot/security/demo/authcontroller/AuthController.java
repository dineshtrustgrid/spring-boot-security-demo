package com.spring.boot.security.demo.authcontroller;

//AuthController.java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.boot.security.demo.dto.RegisterPage;
import com.spring.boot.security.demo.service.UserServices;

import jakarta.validation.Valid;

@Controller
public class AuthController {
 private final UserServices userService;

 public AuthController(UserServices userService) {
     this.userService = userService;
 }

 @GetMapping("/register")
 public String showRegisterForm(Model model) {
     model.addAttribute("registerRequest", new RegisterPage());
     return "register";
 }

 @PostMapping("/register")
 public String registerUser(@Valid @ModelAttribute RegisterPage registerRequest, 
                            BindingResult result, Model model) {
     if (result.hasErrors()) {
         return "register";
     }

     // Check password match
     if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
         result.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match");
         return "register";
     }

     // Check if username or email already exists
     if (userService.existsByUsername(registerRequest.getUsername())) {
         result.rejectValue("username", "error.username", "Username already exists");
         return "register";
     }

     try {
         userService.registerUser(registerRequest);
         model.addAttribute("successMessage", "Registration successful! Please login.");
         return "login";
     } catch (Exception e) {
         model.addAttribute("errorMessage", "Registration failed: " + e.getMessage());
         return "register";
     }
 }

 @GetMapping("/login")
 public String showLoginForm(Model model) {
     return "login";
 }

 @GetMapping("/dashboard")
 public String dashboard() {
     return "dashboard";
 }
}