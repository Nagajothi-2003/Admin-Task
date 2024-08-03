package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserLogin;
import com.example.demo.service.UserLoginService;

@RestController
@RequestMapping("/userLogin")
public class UserLoginController {
	
	@Autowired
	UserLoginService userloginservice;
	
	@PostMapping("/saveuser")
	public ResponseEntity<Boolean> saveUserInfo(@RequestBody UserLogin user ){
		boolean success=userloginservice.saveUserInfo(user);
    	return ResponseEntity.status(HttpStatus.OK).body(success);
 
	}
	
	
	@PostMapping("/checkuser")
	public ResponseEntity<Boolean> checkUser(@RequestBody UserLogin user){
		boolean success=userloginservice.checkUser(user.getEmail(), user.getPassword());
		return ResponseEntity.status(HttpStatus.OK).body(success);
		
	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteProduct(@PathVariable int id){
//		UserLogin user=userloginservice.deleteUser(id);
//		return ResponseEntity.status(HttpStatus.OK).body("Data deleted" + user);
//	}
	
//	@GetMapping("/getAll")
//	public ResponseEntity<List<UserLogin>> getproduct(){
//		
//		List<UserLogin> datas=userloginservice.getproduct();
//		return ResponseEntity.status(HttpStatus.OK).body(datas);
//	}
	
	
	

}
