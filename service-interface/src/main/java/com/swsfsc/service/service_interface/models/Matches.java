package com.swsfsc.service.service_interface.models;

import java.util.Collection;

public class Matches
{
	private Collection<Match> matches;
	
	public Matches(Collection<Match> matches)
	{
		this.matches = matches;
	}

	public Collection<Match> getMatches()
	{
		return matches;
	}
}
