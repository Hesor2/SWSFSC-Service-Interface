package com.swsfsc.service.service_interface.repositories;

import java.util.Collection;

import org.sql2o.Connection;

import com.swsfsc.service.service_interface.models.Competition;
import com.swsfsc.service.service_interface.models.Season;
import com.swsfsc.service.service_interface.models.UserScore;
import com.swsfsc.service.service_interface.models.request_models.Paging;
import com.swsfsc.service.service_interface.models.request_models.SeasonPaging;

public class SeasonRepository extends Repository
{
	public Collection<Season> getAll(String service_code, String user_uid, Paging paging)
	{
		Collection<Season> seasons;
		String sql = "call season_get_all_seasons(:service_code, :user_uid, :page, :page_size)";
		Connection con = getSlaveDB().open();
		seasons = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("page", paging.getPage()).addParameter("page_size", paging.getPage_size())
				.executeAndFetch(Season.class);
		con.close();
		return seasons;
	}

	public Collection<Season> getCurrent(String service_code, String user_uid, Paging paging)
	{
		Collection<Season> seasons;
		String sql = "call season_get_current_seasons(:service_code, :user_uid, :page, :page_size)";
		Connection con = getSlaveDB().open();
		seasons = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("page", paging.getPage()).addParameter("page_size", paging.getPage_size())
				.executeAndFetch(Season.class);
		con.close();
		return seasons;
	}
	
	public Collection<UserScore> getHighScore(String service_code, String user_uid, SeasonPaging seasonPaging)
	{
		Collection<UserScore> highScore;
		String sql = "call season_get_high_scores(:service_code, :user_uid, :season_name, :page, :page_size)";
		Connection con = getSlaveDB().open();
		highScore = con.createQuery(sql).addParameter("service_code", service_code)
				.addParameter("user_uid", user_uid).addParameter("season_name", seasonPaging.getSeason_name())
				.addParameter("page", seasonPaging.getPage()).addParameter("page_size", seasonPaging.getPage_size())
				.executeAndFetch(UserScore.class);
		con.close();
		return highScore;
	}

	public Season create(String service_code, String user_uid, Season season)
	{
		Season newSeason;
		String sql = "call admin_create_season(:service_code, :user_uid, :name, :start_date, :end_date)";
		Connection con = getMasterDB().open();
		newSeason = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("name", season.getName()).addParameter("start_date", season.getStart_date())
				.addParameter("end_date", season.getEnd_date()).executeAndFetchFirst(Season.class);
		con.close();
		return newSeason;
	}

	public Collection<Competition> getCompetitions(String service_code, String user_uid, SeasonPaging seasonPaging)
	{
		Collection<Competition> competitions;
		String sql = "call season_get_all_competitions(:service_code, :user_uid, :season_name, :page, :page_size)";
		Connection con = getSlaveDB().open();
		competitions = con.createQuery(sql).addParameter("service_code", service_code)
				.addParameter("user_uid", user_uid).addParameter("season_name", seasonPaging.getSeason_name())
				.addParameter("page", seasonPaging.getPage()).addParameter("page_size", seasonPaging.getPage_size())
				.executeAndFetch(Competition.class);
		con.close();
		return competitions;
	}
	
	public Collection<Competition> getCurrentCompetitions(String service_code, String user_uid, SeasonPaging seasonPaging)
	{
		Collection<Competition> competitions;
		String sql = "call season_get_current_competitions(:service_code, :user_uid, :season_name, :page, :page_size)";
		Connection con = getSlaveDB().open();
		competitions = con.createQuery(sql).addParameter("service_code", service_code)
				.addParameter("user_uid", user_uid).addParameter("season_name", seasonPaging.getSeason_name())
				.addParameter("page", seasonPaging.getPage()).addParameter("page_size", seasonPaging.getPage_size())
				.executeAndFetch(Competition.class);
		con.close();
		return competitions;
	}
}
