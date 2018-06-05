package com.swsfsc.service.service_interface.repositories;

import java.util.Collection;

import org.sql2o.Connection;

import com.swsfsc.service.service_interface.models.Match;
import com.swsfsc.service.service_interface.models.request_models.Paging;

public class MatchRepository extends Repository
{
	public Match create(String service_code, String user_uid, Match match)
	{
		Match newMatch;
		String sql = "call admin_create_match(:service_code, :user_uid, :season_name, :competition_name, :team_1_name, :team_2_name, :start_date)";
		Connection con = getMasterDB().open();
		newMatch = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("season_name", match.getSeason_name())
				.addParameter("competition_name", match.getCompetition_name())
				.addParameter("team_1_name", match.getTeam_1_name()).addParameter("team_2_name", match.getTeam_2_name())
				.addParameter("start_date", match.getStart_date()).executeAndFetchFirst(Match.class);
		con.close();
		return newMatch;
	}
	
	public Match decideResult(String service_code, String user_uid, Match match)
	{
		Match newMatch;
		String sql = "call admin_decide_match_result(:service_code, :user_uid, :season_name, :competition_name, :team_1_name, :team_2_name, :start_date, :result)";
		Connection con = getMasterDB().open();
		newMatch = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("season_name", match.getSeason_name())
				.addParameter("competition_name", match.getCompetition_name())
				.addParameter("team_1_name", match.getTeam_1_name()).addParameter("team_2_name", match.getTeam_2_name())
				.addParameter("start_date", match.getStart_date()).addParameter("result", match.getResult()).executeAndFetchFirst(Match.class);
		con.close();
		return newMatch;
	}
	
	public Collection<Match> getAll(String service_code, String user_uid, Paging paging)
	{
		Collection<Match> matches;
		String sql = "call match_get_all_matches(:service_code, :user_uid, :page, :page_size)";
		Connection con = getSlaveDB().open();
		matches = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("page", paging.getPage()).addParameter("page_size", paging.getPage_size())
				.executeAndFetch(Match.class);
		con.close();
		return matches;
	}
	
	public Collection<Match> getUpcoming(String service_code, String user_uid, Paging paging)
	{
		Collection<Match> matches;
		String sql = "call match_get_upcoming_matches(:service_code, :user_uid, :page, :page_size)";
		Connection con = getSlaveDB().open();
		matches = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("page", paging.getPage()).addParameter("page_size", paging.getPage_size())
				.executeAndFetch(Match.class);
		con.close();
		return matches;
	}

	public Match makeGuess(String service_code, String user_uid, Match match)
	{
		Match newMatch;
		String sql = "call match_make_guess(:service_code, :user_uid, :season_name, :competition_name, :team_1_name, :team_2_name, :start_date, :result)";
		Connection con = getMasterDB().open();
		newMatch = con.createQuery(sql).addParameter("service_code", service_code).addParameter("user_uid", user_uid)
				.addParameter("season_name", match.getSeason_name())
				.addParameter("competition_name", match.getCompetition_name())
				.addParameter("team_1_name", match.getTeam_1_name()).addParameter("team_2_name", match.getTeam_2_name())
				.addParameter("start_date", match.getStart_date()).addParameter("result", match.getGuess()).executeAndFetchFirst(Match.class);
		con.close();
		return newMatch;
	}
}
