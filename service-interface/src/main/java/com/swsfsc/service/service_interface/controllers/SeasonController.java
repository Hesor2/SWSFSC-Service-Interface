package com.swsfsc.service.service_interface.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.Competitions;
import com.swsfsc.service.service_interface.models.Season;
import com.swsfsc.service.service_interface.models.Seasons;
import com.swsfsc.service.service_interface.models.UserScores;
import com.swsfsc.service.service_interface.models.request_models.Paging;
import com.swsfsc.service.service_interface.models.request_models.SeasonPaging;
import com.swsfsc.service.service_interface.repositories.SeasonRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

@RestController
public class SeasonController
{
	private SeasonRepository repo = new SeasonRepository();
	private FirebaseConnection firebase = new FirebaseConnection();

	@RequestMapping("/seasons")
	public Seasons getSeasons(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Paging paging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new Seasons(repo.getAll(service_code, uid, paging));
	}

	@RequestMapping("/seasons/current")
	public Seasons getCurrentSeasons(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Paging paging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new Seasons(repo.getCurrent(service_code, uid, paging));
	}
	
	@RequestMapping("/seasons/highscore")
	public UserScores getHighScore(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody SeasonPaging seasonPaging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new UserScores(repo.getHighScore(service_code, uid, seasonPaging));
	}

	@RequestMapping("/seasons/create")
	public Season createSeason(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Season season) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.create(service_code, uid, season);
	}
	
	@RequestMapping("/seasons/competitions")
	public Competitions getCompetitions(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody SeasonPaging seasonPaging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new Competitions(repo.getCompetitions(service_code, uid, seasonPaging));
	}
	
	@RequestMapping("/seasons/competitions/current")
	public Competitions getCurrentCompetitions(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody SeasonPaging seasonPaging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new Competitions(repo.getCurrentCompetitions(service_code, uid, seasonPaging));
	}
	
}