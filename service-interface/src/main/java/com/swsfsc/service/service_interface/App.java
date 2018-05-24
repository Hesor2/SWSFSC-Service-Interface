package com.swsfsc.service.service_interface;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.swsfsc.service.service_interface.utilities.MasterDatabaseConnection;
import com.swsfsc.service.service_interface.utilities.SlaveDatabaseConnection;

@SpringBootApplication
@ComponentScan
public class App
{
	public static void main(String[] args)
	{
		try
		{

			FileInputStream serviceAccount =
			  new FileInputStream("swsfsc-firebase-adminsdk-ansce-da7248dc10.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://swsfsc.firebaseio.com")
			  .build();
			
			FirebaseApp.initializeApp(options);
			
			SlaveDatabaseConnection.loadDatabaseCredentials("slave-database-credentials.txt");
			MasterDatabaseConnection.loadDatabaseCredentials("master-database-credentials.txt");
			
			SpringApplication.run(App.class, args);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
