package com.swsfsc.service.service_interface.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.Admin;
import com.swsfsc.service.service_interface.repositories.AdminRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

@RestController
public class AdminController
{
	private AdminRepository repo = new AdminRepository();
	private FirebaseConnection firebase = new FirebaseConnection();
	
	@RequestMapping("/admin/create")
	public Admin createAdmin(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Admin admin) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.create(service_code, uid, admin);
	}
}
