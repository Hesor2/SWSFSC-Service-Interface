package com.swsfsc.service.service_interface.repositories;

import org.sql2o.Connection;

import com.swsfsc.service.service_interface.models.Team;

public class TeamRepository extends Repository
{
	public Team create(String service_code, String user_uid, Team team)
	{
		Team newTeam;
		String sql = "call admin_create_team(:service_code, :user_uid, :name)";
		Connection con = getMasterDB().open();
		newTeam = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("name", team.getName()).executeAndFetchFirst(Team.class);
		con.close();
		return newTeam;
	}
}
