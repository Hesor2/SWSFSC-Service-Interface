package com.swsfsc.service.service_interface.repositories;

import org.sql2o.Connection;

import com.swsfsc.service.service_interface.models.Admin;

public class AdminRepository extends Repository
{
	public Admin create(String service_code, String user_uid, Admin admin)
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
}
