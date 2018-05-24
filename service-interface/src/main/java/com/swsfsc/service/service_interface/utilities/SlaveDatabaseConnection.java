package com.swsfsc.service.service_interface.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.sql2o.Sql2o;

public class SlaveDatabaseConnection  extends Sql2o
{
	private static SlaveDatabaseConnection instance;
	private static String url;
	private static String user;
	private static String password;
	
	
	private SlaveDatabaseConnection()
	{
		super(url, user, password);
	}
	
	public static SlaveDatabaseConnection getInstance()
	{
		if(instance == null)
		{
			instance = new SlaveDatabaseConnection();
		}
		return instance;
	}
	
	public static void loadDatabaseCredentials(String credentialsFilePath) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(credentialsFilePath));
		url = sc.nextLine();
		user = sc.nextLine();
		password = sc.nextLine();
		sc.close();
	}
}
