package com.swsfsc.service.service_interface.models;

public class PendingPayment
{
	private String season_name;
	private String competition_name;
	private String payment_code;

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

	public String getPayment_code()
	{
		return payment_code;
	}

	public void setPayment_code(String payment_code)
	{
		this.payment_code = payment_code;
	}
}
