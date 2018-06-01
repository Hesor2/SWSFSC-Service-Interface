package com.swsfsc.service.service_interface.repositories;

import java.util.Collection;

import org.sql2o.Connection;

import com.swsfsc.service.service_interface.models.Competition;
import com.swsfsc.service.service_interface.models.UserScore;
import com.swsfsc.service.service_interface.models.request_models.CompetitionPaging;
import com.swsfsc.service.service_interface.models.request_models.Paging;
import com.swsfsc.service.service_interface.models.request_models.SeasonPaging;

public class CompetitionRepository extends Repository
{
	public Collection<Competition> getAll(String service_code, String user_uid, Paging paging)
	{
		Collection<Competition> competitions;
		String sql = "call competition_get_all_competitions(:service_code, :user_uid, :page, :page_size)";
		Connection con = getSlaveDB().open();
		competitions = con.createQuery(sql).addParameter("service_code", service_code)
				.addParameter("user_uid", user_uid).addParameter("page", paging.getPage())
				.addParameter("page_size", paging.getPage_size()).executeAndFetch(Competition.class);
		con.close();
		return competitions;
	}

	public Collection<Competition> getCurrent(String service_code, String user_uid, Paging paging)
	{
		Collection<Competition> competitions;
		String sql = "call competition_get_current_competitions(:service_code, :user_uid, :page, :page_size)";
		Connection con = getSlaveDB().open();
		competitions = con.createQuery(sql).addParameter("service_code", service_code)
				.addParameter("user_uid", user_uid).addParameter("page", paging.getPage())
				.addParameter("page_size", paging.getPage_size()).executeAndFetch(Competition.class);
		con.close();
		return competitions;
	}

	public Collection<UserScore> getHighScore(String service_code, String user_uid, CompetitionPaging competitionPaging)
	{
		Collection<UserScore> highScore;
		String sql = "call competition_get_high_scores(:service_code, :user_uid, :season_name, :competition_name, :page, :page_size)";
		Connection con = getSlaveDB().open();
		highScore = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("season_name", competitionPaging.getSeason_name())
				.addParameter("competition_name", competitionPaging.getCompetition_name())
				.addParameter("page", competitionPaging.getPage())
				.addParameter("page_size", competitionPaging.getPage_size()).executeAndFetch(UserScore.class);
		con.close();
		return highScore;
	}
}
