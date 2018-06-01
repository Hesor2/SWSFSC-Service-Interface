package com.swsfsc.service.service_interface.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.Competitions;
import com.swsfsc.service.service_interface.models.UserScores;
import com.swsfsc.service.service_interface.models.request_models.CompetitionPaging;
import com.swsfsc.service.service_interface.models.request_models.Paging;
import com.swsfsc.service.service_interface.models.request_models.SeasonPaging;
import com.swsfsc.service.service_interface.repositories.CompetitionRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

@RestController
public class CompetitionController
{
	private CompetitionRepository repo = new CompetitionRepository();
	private FirebaseConnection firebase = new FirebaseConnection();
	
	@RequestMapping("/competitions")
	public Competitions getCompetitions(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Paging paging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new Competitions(repo.getAll(service_code, uid, paging));
	}

	@RequestMapping("/competitions/current")
	public Competitions getCurrentCompetitions(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Paging paging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new Competitions(repo.getCurrent(service_code, uid, paging));
	}
	
	@RequestMapping("/competitions/highscore")
	public UserScores getHighScore(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody CompetitionPaging competitionPaging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new UserScores(repo.getHighScore(service_code, uid, competitionPaging));
	}
}
