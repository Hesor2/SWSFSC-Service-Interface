package com.swsfsc.service.service_interface.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.Season;
import com.swsfsc.service.service_interface.repositories.SeasonRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

import java.util.Collection;

@RestController
public class SeasonController
{
	SeasonRepository repo = new SeasonRepository();
	FirebaseConnection firebase = new FirebaseConnection();

	@RequestMapping("/seasons")
	public Collection<Season> getSeasons(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.getAll(service_code, uid);
	}

	@RequestMapping("/seasons/current")
	public Collection<Season> getCurrentSeasons(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.getCurrent(service_code, uid);
	}

	@RequestMapping("/seasons/create")
	public Season createSeason(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Season season) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.create(service_code, uid, season);
	}
}