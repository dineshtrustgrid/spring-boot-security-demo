//package com.spring.boot.security.demo.controller;
//
////HomeController.java
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HomeController {
// 
// @GetMapping("/")
// public String home() {
//     return "Welcome!"; // Requires authentication
// }
//
// @GetMapping("/user")
// @PreAuthorize("hasRole('USER')")
// public String userPage() {
//     return "User Content";
// }
//
// @GetMapping("/admin")
// @PreAuthorize("hasRole('ADMIN')")
// public String adminPage() {
//     return "Admin Content";
// }
//
// @GetMapping("/login")
// public String login() {
//     return "Login Page";
// }
//}