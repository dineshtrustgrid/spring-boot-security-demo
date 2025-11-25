package com.spring.boot.security.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class RoleEntity {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 // Constructors, getters, setters
}



