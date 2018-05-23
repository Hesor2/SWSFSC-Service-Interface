package com.swsfsc.service.service_interface.utilities;

public class SlaveDatabaseConnection extends DatabaseConnection
{
	private final static String DB_URL = "mysql://127.0.0.1:3306/sport_clubs_service?autoReconnect=true&useSSL=false";
	private static SlaveDatabaseConnection instance;
	
	private SlaveDatabaseConnection()
	{
		super(DB_URL);
	}
	
	public static SlaveDatabaseConnection getInstance()
	{
		if(instance == null)
		{
			instance = new SlaveDatabaseConnection();
		}
		return instance;
	}
}
