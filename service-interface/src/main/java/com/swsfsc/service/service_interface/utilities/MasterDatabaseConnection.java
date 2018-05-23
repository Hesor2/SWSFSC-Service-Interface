package com.swsfsc.service.service_interface.utilities;

import org.sql2o.Sql2o;

public class MasterDatabaseConnection extends Sql2o
{
	private final static String DB_URL = "mysql://127.0.0.1:3306/sport_clubs_service?autoReconnect=true&useSSL=false";
	private static MasterDatabaseConnection instance;
	
	private MasterDatabaseConnection()
	{
		super(DB_URL);
	}
	
	public static MasterDatabaseConnection getInstance()
	{
		if(instance == null)
		{
			instance = new MasterDatabaseConnection();
		}
		return instance;
	}
}
