package com.spring.boot.security.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//UserService.java
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.security.demo.dto.RegisterPage;
import com.spring.boot.security.demo.entity.RoleEntity;
import com.spring.boot.security.demo.entity.UserEntity;
import com.spring.boot.security.demo.repository.RoleRepository;
import com.spring.boot.security.demo.repository.UserRepository;

@Service
@Transactional
public class UserServices {
	
	@Autowired
 private final UserRepository userRepository;
	@Autowired
 private final RoleRepository roleRepository;
	@Autowired
 private final PasswordEncoder passwordEncoder;

 public UserServices(UserRepository userRepository, 
                    RoleRepository roleRepository, 
                    PasswordEncoder passwordEncoder) {
     this.userRepository = userRepository;
     this.roleRepository = roleRepository;
     this.passwordEncoder = passwordEncoder;
 }

 public UserEntity createUser(String username, String password, String roleName) {
	 UserEntity user = new UserEntity();
     user.setUsername(username);
     user.setPassword(passwordEncoder.encode(password));
     
     RoleEntity role = roleRepository.findByName(roleName);
     if (role == null) {
         role = new RoleEntity();
         role.setName(roleName);
         role = roleRepository.save(role);
     }
     user.setRoles(List.of(role));
     return userRepository.save(user);
 }
 
 public UserEntity registerUser(RegisterPage request) {
     // Check if user already exists
     if (userRepository.findByUsername(request.getUsername()).isPresent()) {
         throw new RuntimeException("Username already exists");
     }

     // Create new user
     UserEntity user = new UserEntity();
     user.setUsername(request.getUsername());
     user.setEmail(request.getEmail());
     user.setPassword(passwordEncoder.encode(request.getPassword()));

     // Assign default USER role
     RoleEntity userRole = roleRepository.findByName("USER");
     if (userRole == null) {
         userRole = new RoleEntity();
         userRole.setName("USER");
         userRole = roleRepository.save(userRole);
     }
     
     user.setRoles(List.of(userRole));
     return userRepository.save(user);
 }
 
 
 
 public RoleEntity createAdminRoleIfNotExist() {
	    RoleEntity admin = roleRepository.findByName("SUPERADMIN");
	    if (admin == null) {
	        admin = new RoleEntity();
	        admin.setName("SUPERADMIN");
	        roleRepository.save(admin);
	    }
	    return admin;
	}

 
 public UserEntity createAdmin(String username, String password, String email) {

	    UserEntity admin = new UserEntity();
	    admin.setUsername(username);
	    admin.setEmail(email);
	    admin.setPassword(passwordEncoder.encode(password));

	    RoleEntity adminRole = roleRepository.findByName("ADMIN");
	    if (adminRole == null) {
	        adminRole = new RoleEntity();
	        adminRole.setName("ADMIN");
	        adminRole = roleRepository.save(adminRole);
	    }

	    admin.setRoles(List.of(adminRole));
	    return userRepository.save(admin);
	}

 

 public boolean existsByUsername(String username) {
     return userRepository.findByUsername(username).isPresent();
 }

 public boolean existsByEmail(String email) {
     return userRepository.existsByEmail(email);
 }

 
}