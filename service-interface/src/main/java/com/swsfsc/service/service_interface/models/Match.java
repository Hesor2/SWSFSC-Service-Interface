package com.swsfsc.service.service_interface.models;

import java.sql.Timestamp;

public class Match
{
	private String season_name;
	private String competition_name;
	private String team_1_name;
	private String team_2_name;
	private Timestamp start_date;
	private Integer result;
	private Integer guess;

	public String getSeason_name()
	{
		return season_name;
	}

	public void setSeason_name(String season_name)
	{
		this.season_name = season_name;
	}

	public String getCompetition_name()
	{
		return competition_name;
	}

	public void setCompetition_name(String competition_name)
	{
		this.competition_name = competition_name;
	}

	public String getTeam_1_name()
	{
		return team_1_name;
	}

	public void setTeam_1_name(String team_1_name)
	{
		this.team_1_name = team_1_name;
	}

	public String getTeam_2_name()
	{
		return team_2_name;
	}

	public void setTeam_2_name(String team_2_name)
	{
		this.team_2_name = team_2_name;
	}

	public Timestamp getStart_date()
	{
		return start_date;
	}

	public void setStart_date(Timestamp start_date)
	{
		this.start_date = start_date;
	}

	public Integer getResult()
	{
		return result;
	}

	public void setResult(Integer result)
	{
		this.result = result;
	}

	public Integer getGuess()
	{
		return guess;
	}

	public void setGuess(Integer guess)
	{
		this.guess = guess;
	}

}
