package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.JoinDao;
import jp.co.example.entity.Join;

@Repository
public class PgJoinDao implements JoinDao{

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	 private static final String SELECT_USERNAME_FINDBY_PARTYID = "select user_name from joins join users on joins.login_id =users.login_id join party on joins.party_name =party.party_name where party.party_name =:partyName";
	 private static final String INSERT = "INSERT INTO joins (login_id,party_name) VALUES (:loginId,:partyName)";


	@Override
	public void insert(Join join) {
		MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", join.getLoginId());
        param.addValue("partyName", join.getPartyName());

        jdbcTemplate.update(INSERT, param);

	}

	@Override
	public List<Join> findByPartyName(String partyName) {
		MapSqlParameterSource param = new MapSqlParameterSource();
	    List<Join> resultList = jdbcTemplate.query(SELECT_USERNAME_FINDBY_PARTYID, new BeanPropertyRowMapper<Join>(Join.class));
		param.addValue("partyName", partyName);
		return resultList;
	}

	@Override
    public List<Join> findByName(String partyName) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("partyName", partyName);

        List<Join> resultList = jdbcTemplate.query(SELECT_USERNAME_FINDBY_PARTYID, param,
                new BeanPropertyRowMapper<Join>(Join.class));

        return resultList.isEmpty() ? null : resultList;
    }


}