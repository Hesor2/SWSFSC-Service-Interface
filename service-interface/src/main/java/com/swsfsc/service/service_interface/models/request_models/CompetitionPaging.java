package com.swsfsc.service.service_interface.models.request_models;

public class CompetitionPaging extends SeasonPaging
{
	private String competition_name;

	public String getCompetition_name()
	{
		return competition_name;
	}

	public void setCompetition_name(String competition_name)
	{
		this.competition_name = competition_name;
	}
}
