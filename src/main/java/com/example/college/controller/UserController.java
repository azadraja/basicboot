package com.example.college.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.college.entity.User;
import com.example.college.service.impl.UserServiceImpl;

@RestController("api/user")
public class UserController extends AbstractController<UserServiceImpl, User, Integer>{

}
