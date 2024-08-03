package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserLogin;
@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Integer>  {

	boolean existsByEmail(String email);
	UserLogin findByEmail(String email);
}
