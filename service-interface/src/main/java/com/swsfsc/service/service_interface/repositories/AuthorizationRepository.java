package com.swsfsc.service.service_interface.repositories;

import org.sql2o.Connection;

import com.swsfsc.service.service_interface.models.Admin;
import com.swsfsc.service.service_interface.models.User;

public class AuthorizationRepository extends Repository
{
	public void checkOwner(String service_code, String user_uid)
	{
		String sql = "call owner_check_owner(:service_code, :user_uid)";
		Connection con = getMasterDB().open();
		con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.executeUpdate();
		con.close();
	}

	public Admin createAdmin(String service_code, String user_uid, Admin admin)
	{
		Admin newAdmin;
		String sql = "call owner_create_admin(:service_code, :user_uid, :admin_name, :admin_payment_information)";
		Connection con = getMasterDB().open();
		newAdmin = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("admin_name", admin.getName())
				.addParameter("admin_payment_information", admin.getPayment_information())
				.executeAndFetchFirst(Admin.class);
		con.close();
		return newAdmin;
	}

	public void checkAdmin(String service_code, String user_uid)
	{
		String sql = "call admin_check_admin(:service_code, :user_uid)";
		Connection con = getMasterDB().open();
		con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.executeUpdate();
		con.close();
	}
	
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
