package com.swsfsc.service.service_interface.repositories;

import java.util.Collection;

import org.sql2o.Connection;

import com.swsfsc.service.service_interface.models.Season;

public class SeasonRepository extends Repository
{
	public Collection<Season> getAll(String service_code, String user_uid)
	{
		Collection<Season> seasons;
		String sql = "call season_get_all_seasons(:service_code, :user_uid)";
		Connection con = getSlaveDB().open();
		seasons = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.executeAndFetch(Season.class);

		return seasons;
	}

	public Collection<Season> getCurrent(String service_code, String user_uid)
	{
		Collection<Season> seasons;
		String sql = "call season_get_current_seasons(:service_code, :user_uid)";
		Connection con = getSlaveDB().open();
		seasons = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.executeAndFetch(Season.class);

		return seasons;
	}

	public Season create(String service_code, String user_uid, Season season)
	{
		Season newSeason;
		String sql = "call admin_create_season(:service_code, :user_uid, :name, :start_date, :end_date)";
		Connection con = getMasterDB().open();
		newSeason = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("name", season.getName()).addParameter("start_date", season.getStart_date())
				.addParameter("end_date", season.getEnd_date()).executeAndFetchFirst(Season.class);

		return newSeason;
	}
}
