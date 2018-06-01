package com.swsfsc.service.service_interface.models;

import java.util.Collection;

public class Competitions
{
	private Collection<Competition> competitions;
	
	public Competitions(Collection<Competition> competitions)
	{
		this.competitions = competitions;
	}

	public Collection<Competition> getCompetitions()
	{
		return competitions;
	}
}
