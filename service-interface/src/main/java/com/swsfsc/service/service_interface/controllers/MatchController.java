package com.swsfsc.service.service_interface.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.Match;
import com.swsfsc.service.service_interface.models.Matches;
import com.swsfsc.service.service_interface.models.request_models.Paging;
import com.swsfsc.service.service_interface.repositories.MatchRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

@RestController
public class MatchController
{
	private MatchRepository repo = new MatchRepository();
	private FirebaseConnection firebase = new FirebaseConnection();
	
	@RequestMapping("/matches/create")
	public Match createMatch(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Match match) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.create(service_code, uid, match);
	}
	
	@RequestMapping("/matches/decideResult")
	public Match decideResult(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Match match) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.decideResult(service_code, uid, match);
	}
	
	@RequestMapping("/matches")
	public Matches getAllMatches(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Paging paging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new Matches(repo.getAll(service_code, uid, paging));
	}
	
	@RequestMapping("/matches/upcoming")
	public Matches getUpcomingMatches(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Paging paging) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return new Matches(repo.getUpcoming(service_code, uid, paging));
	}
	
	@RequestMapping("/matches/guess")
	public Match makeGuess(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Match match) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.makeGuess(service_code, uid, match);
	}
}
