package com.example.college.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends CollegeEntity<Integer> {
	
	@Column(nullable = false, length = 300)
    private String name;
    
	@Column(nullable = false, length = 300)
	private String email;
}