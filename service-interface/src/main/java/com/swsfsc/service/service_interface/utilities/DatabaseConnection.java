package com.swsfsc.service.service_interface.utilities;

import org.sql2o.Sql2o;

public abstract class DatabaseConnection extends Sql2o
{
	private final static String  DB_USER = "service2";
	private final static String  DB_PASS = "password";
	
	public DatabaseConnection(String url)
	{
		super(url, DB_USER, DB_PASS);
	}
}
