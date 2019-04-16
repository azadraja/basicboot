package com.example.college.repository;

import org.springframework.stereotype.Repository;

import com.example.college.entity.User;

@Repository
public interface IUserRepository extends ICollegeRepository<User, Integer>{

}
