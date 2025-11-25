package com.spring.boot.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.security.demo.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
	RoleEntity findByName(String name);

}
