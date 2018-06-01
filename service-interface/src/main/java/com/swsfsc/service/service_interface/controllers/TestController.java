package com.swsfsc.service.service_interface.controllers;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.Season;
import com.swsfsc.service.service_interface.repositories.SeasonRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

@RestController
public class TestController
{
	private SeasonRepository repo = new SeasonRepository();
	private FirebaseConnection firebase = new FirebaseConnection();

	/*@SuppressWarnings("deprecation")
	@RequestMapping("/test")
	public String setupTest(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		Timestamp start_date = new Timestamp(100000000);
		Timestamp end_date = new Timestamp(100010000);
		for(int i = 1; i <= 20000; i++)
		{
			Season season = new Season("test season"+i, start_date, end_date);
			repo.create(service_code, uid, season);
		}
		return "Setup Completed";
	}*/
}