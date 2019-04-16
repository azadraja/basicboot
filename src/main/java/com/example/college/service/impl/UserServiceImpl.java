package com.example.college.service.impl;

import org.springframework.stereotype.Service;

import com.example.college.entity.User;
import com.example.college.repository.IUserRepository;
import com.example.college.service.IUser;

@Service
public class UserServiceImpl extends AbstractServiceImpl<IUserRepository, User, Integer> implements IUser{

	public UserServiceImpl() {
		super(User.class);
	}
}
