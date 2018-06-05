package com.swsfsc.service.service_interface.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.swsfsc.service.service_interface.models.Team;
import com.swsfsc.service.service_interface.repositories.TeamRepository;
import com.swsfsc.service.service_interface.utilities.FirebaseConnection;

@RestController
public class TeamContoller
{
	private TeamRepository repo = new TeamRepository();
	private FirebaseConnection firebase = new FirebaseConnection();
	
	@RequestMapping("/teams/create")
	public Team createTeam(@RequestHeader("ServiceCode") String service_code,
			@RequestHeader("Authorization") String auth_token, @RequestBody Team team) throws FirebaseAuthException
	{
		String uid = firebase.getUid(auth_token);
		return repo.create(service_code, uid, team);
	}
}
