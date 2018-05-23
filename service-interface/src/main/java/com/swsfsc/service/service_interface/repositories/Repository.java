package com.swsfsc.service.service_interface.repositories;

import com.swsfsc.service.service_interface.utilities.MasterDatabaseConnection;
import com.swsfsc.service.service_interface.utilities.SlaveDatabaseConnection;

public abstract class Repository
{
	private SlaveDatabaseConnection slaveDB = SlaveDatabaseConnection.getInstance();
	private MasterDatabaseConnection masterDB = MasterDatabaseConnection.getInstance();

	public SlaveDatabaseConnection getSlaveDB()
	{
		return slaveDB;
	}

	public MasterDatabaseConnection getMasterDB()
	{
		return masterDB;
	}

}
