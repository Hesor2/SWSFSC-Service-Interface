package com.swsfsc.service.service_interface.models;

import java.sql.Timestamp;

public class Season
{
	private String name;
	private Timestamp start_date;
	private Timestamp end_date;
	
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


}