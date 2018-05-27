package com.swsfsc.service.service_interface.models;

import java.util.Collection;

public class Seasons
{
	private Collection<Season> seasons;
	
	public Seasons(Collection<Season> seasons)
	{
		this.seasons = seasons;
	}

	public Collection<Season> getSeasons()
	{
		return seasons;
	}
}
