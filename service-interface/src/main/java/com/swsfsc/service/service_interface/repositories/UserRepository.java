package com.swsfsc.service.service_interface.repositories;

import org.sql2o.Connection;

import com.swsfsc.service.service_interface.models.User;

public class UserRepository extends Repository
{
	public User register(String service_code, String user_uid, User user)
	{
		User newUser;
		String sql = "call user_register(:service_code, :user_uid, :name)";
		Connection con = getMasterDB().open();
		newUser = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("name", user.getName()).executeAndFetchFirst(User.class);
		con.close();
		return newUser;
	}
	
	public void checkName(String service_code, User user)
	{
		String sql = "call user_check_name_availability(:service_code, :name)";
		Connection con = getSlaveDB().open();
		con.createQuery(sql).addParameter("service_code", service_code).addParameter("name", user.getName()).executeUpdate();
		con.close();
	}
}
