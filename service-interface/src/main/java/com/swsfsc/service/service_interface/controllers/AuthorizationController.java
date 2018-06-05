package com.swsfsc.service.service_interface.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.Admin;
import com.swsfsc.service.service_interface.models.User;
import com.swsfsc.service.service_interface.repositories.AuthorizationRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

@RestController
public class AuthorizationController
{
	private AuthorizationRepository repo = new AuthorizationRepository();
	private FirebaseConnection firebase = new FirebaseConnection();
	
	@RequestMapping("/authorization/checkOwner")
	public String checkOwner(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		repo.checkOwner(service_code, uid);
		return "User is the owner";
	}
	
	@RequestMapping("/authorization/createAdmin")
	public Admin createAdmin(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Admin admin) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.createAdmin(service_code, uid, admin);
	}
	
	@RequestMapping("/authorization/checkAdmin")
	public String checkAdmin(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		repo.checkAdmin(service_code, uid);
		return "User is an admin";
	}
	
	@RequestMapping("/authorization/register")
	public User registerUser(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody User user) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.register(service_code, uid, user);
	}
	
	@RequestMapping("/authorization/checkName")
	public String checkName(@RequestHeader("ServiceCode") String service_code, @RequestBody User user) throws FirebaseAuthException
	{
		repo.checkName(service_code, user);
		return "Name is available";
	}
}
