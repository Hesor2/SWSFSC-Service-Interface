package com.swsfsc.service.service_interface.models;

import java.sql.Timestamp;

public class Competition
{
	private String season_name;
	private String name;
	private Timestamp start_date;
	private Timestamp end_date;
	private String prize;
	private String winner;
	private String payment_information;
	private Boolean payment_confirmed;

	public String getSeason_name()
	{
		return season_name;
	}

	public void setSeason_name(String season_name)
	{
		this.season_name = season_name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Timestamp getStart_date()
	{
		return start_date;
	}

	public void setStart_date(Timestamp start_date)
	{
		this.start_date = start_date;
	}

	public Timestamp getEnd_date()
	{
		return end_date;
	}

	public void setEnd_date(Timestamp end_date)
	{
		this.end_date = end_date;
	}

	public String getPrize()
	{
		return prize;
	}

	public void setPrize(String prize)
	{
		this.prize = prize;
	}

	public String getWinner()
	{
		return winner;
	}

	public void setWinner(String winner)
	{
		this.winner = winner;
	}

	public String getPayment_information()
	{
		return payment_information;
	}

	public void setPayment_information(String payment_information)
	{
		this.payment_information = payment_information;
	}

	public Boolean getPayment_confirmed()
	{
		return payment_confirmed;
	}

	public void setPayment_confirmed(Boolean payment_confirmed)
	{
		this.payment_confirmed = payment_confirmed;
	}
}
