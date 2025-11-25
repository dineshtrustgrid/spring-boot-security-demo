package com.spring.boot.security.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.security.demo.entity.UserEntity;

public interface UserRepository  extends JpaRepository<UserEntity, Long>{
	
	Optional<UserEntity> findByUsername(String username);
	 boolean existsByEmail(String email);
}
