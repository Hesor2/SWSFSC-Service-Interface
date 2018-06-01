package com.swsfsc.service.service_interface.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.User;
import com.swsfsc.service.service_interface.repositories.UserRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

@RestController
public class UserController
{
	private UserRepository repo = new UserRepository();
	private FirebaseConnection firebase = new FirebaseConnection();
	
	@RequestMapping("/user/register")
	public User registerUser(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody User user) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.register(service_code, uid, user);
	}
	
	@RequestMapping("/user/checkName")
	public String checkName(@RequestHeader("ServiceCode") String service_code, @RequestBody User user) throws FirebaseAuthException
	{
		repo.checkName(service_code, user);
		return "Name is available";
	}
}
