package com.swsfsc.service.service_interface.models;

import java.util.Collection;

public class UserScores
{
	private Collection<UserScore> userScores;
	
	public UserScores(Collection<UserScore> userScores)
	{
		this.userScores = userScores;
	}

	public Collection<UserScore> getUserScores()
	{
		return userScores;
	}
}
