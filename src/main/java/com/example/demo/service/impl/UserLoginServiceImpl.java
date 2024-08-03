package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserLogin;
import com.example.demo.repo.UserLoginRepo;
import com.example.demo.service.UserLoginService;
@Service
public class UserLoginServiceImpl implements UserLoginService{
	@Autowired
	UserLoginRepo userrepo;
	
	@Override
	public boolean saveUserInfo(UserLogin user) {
	    if (user == null || user.getEmail() == null || user.getPassword() == null) {
	        return false; // Invalid input
	    }

	    // Check if user exists by email
	    UserLogin existingUser = userrepo.findByEmail(user.getEmail());

	    if (existingUser != null) {
	        // User exists, check password
	        if (existingUser.getPassword().equals(user.getPassword())) {
	            return true; // User exists and password matches
	        } else {
	            return false; // Password does not match
	        }
	    } else {
	        // User does not exist, save the new user
	        user.setCreatedAt(new Date(System.currentTimeMillis()));
	        userrepo.saveAndFlush(user);
	        return true; // New user saved successfully
	    }
	}
	
//	@Override
//	public boolean saveUserInfo(UserLogin user) {
//		if(userrepo.existsByEmail(user.getEmail())) {
//			return false;
//		}
//		else if(user !=null && user.getPassword().equals())
//		user.setCreatedAt(new Date(System.currentTimeMillis()));
//		UserLogin savedEntity=userrepo.saveAndFlush(user);
//		return true;
//	}
	
	
	
	@Override
	public boolean checkUser(String email,String password) {
		
		UserLogin user=userrepo.findByEmail(email);
		if(user!=null && user.getPassword().equals(password)) {
			return true;
		}
		else
			return false;
	}
	
	@Override
	public UserLogin deleteUser(int id) {
		UserLogin user=userrepo.findById(id).get();
		if(user!=null) {
			userrepo.delete(user);
		}
		return user;
	}
	
	@Override
	public List<UserLogin> getAllUser(){
		
		return  userrepo.findAll();
	}
	
	@Override
	public UserLogin updateuser(int id,UserLogin updatedUser) {
		UserLogin Existinguser=userrepo.findById(id).orElse(null);
		if(Existinguser!=null) {
			Existinguser.setEmail(updatedUser.getEmail());
			Existinguser.setPassword(updatedUser.getPassword());
			return userrepo.save(Existinguser);
		}
		return null;
	}
	

}
