package com.example.demo.service;

import java.util.List;


import com.example.demo.model.UserLogin;

public interface UserLoginService {
	boolean saveUserInfo(UserLogin user);
	boolean checkUser(String email,String password);
	UserLogin deleteUser(int id);
	List<UserLogin> getAllUser();
	UserLogin updateuser(int id,UserLogin updatedUser);
}
//BookItem updateItem(Long id, BookItem updatedItem);
