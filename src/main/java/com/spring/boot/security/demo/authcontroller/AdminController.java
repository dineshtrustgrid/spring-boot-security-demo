package com.spring.boot.security.demo.authcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/users")
    public String manageUsers() {
        return "admin-users";
    }
}
