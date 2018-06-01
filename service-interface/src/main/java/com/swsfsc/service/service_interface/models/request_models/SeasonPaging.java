package com.swsfsc.service.service_interface.models.request_models;

public class SeasonPaging extends Paging
{
	private String season_name;

	public String getSeason_name()
	{
		return season_name;
	}

	public void setSeason_name(String season_name)
	{
		this.season_name = season_name;
	}
}
