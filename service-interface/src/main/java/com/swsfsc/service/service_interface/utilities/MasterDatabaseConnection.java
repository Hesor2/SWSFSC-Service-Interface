package com.swsfsc.service.service_interface.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.sql2o.Sql2o;

public class MasterDatabaseConnection  extends Sql2o
{
	private static MasterDatabaseConnection instance;
	private static String url;
	private static String user;
	private static String password;
	
	
	private MasterDatabaseConnection()
	{
		super(url, user, password);
	}
	
	public static MasterDatabaseConnection getInstance()
	{
		if(instance == null)
		{
			instance = new MasterDatabaseConnection();
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
