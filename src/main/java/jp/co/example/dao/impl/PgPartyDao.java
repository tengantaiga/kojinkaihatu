package jp.co.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.PartyDao;
import jp.co.example.entity.Party;

@Repository
public class PgPartyDao implements PartyDao {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "SELECT * FROM party ORDER BY party_id";
    private static final String SELECT = "SELECT * FROM party ";
    private static final String SELECT_BY_LOGIN_ID = "SELECT * FROM party WHERE party_name = :partyName";
    private static final String SELECT_BY_LOGIN_ID_AND_PASS = "SELECT * FROM party WHERE party_name = :partyName AND party_pass = :partyPass";
    private static final String ORDER_BY = " ORDER BY party_id";
    private static final String INSERT = "INSERT INTO party (party_name,party_pass,party_date,party_place,come) VALUES (:partyName,:partyPass,:date,:place,:come)";
    private static final String UPDATE = "UPDATE party SET party_name = :partyName, party_pass = :partyPass, party_date = :partyDate, party_place= :partyPlace, come = :partyCome WHERE party_id = :partyId";
    private static final String DELETE = "DELETE FROM party WHERE party_id = :partyId";


    @Override
    public List<Party> findAll() {
        List<Party> resultList = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Party>(Party.class));

        return resultList;
    }

    /**
     * 条件を指定した検索
     */
    @Override
    public List<Party> find(Party party) {

        if (party == null || party.isEmptyCondition()) {
            // 検索条件が無い場合は全検索
            return findAll();
        }

        // 検索条件の有無に応じて、sqlのWHERE句に指定する条件文、
        // Parameterをストックしていく。

        List<String> condition = new ArrayList<String>();
        MapSqlParameterSource param = new MapSqlParameterSource();

        String partyName = party.getPartyName();


        if (partyName != null && !partyName.isEmpty()) {
            condition.add("party_name = :partyName");
            param.addValue("partyName", partyName);

        }



        // WHERE句の文字列生成
        String whereString = String.join(" AND ", condition.toArray(new String[] {}));

        // SQL文生成
        String sql = SELECT + whereString + ORDER_BY;

        List<Party> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Party>(Party.class));

        return resultList;
    }

    /**
     * user_idによる検索
     */
    @Override
    public Party findByName(String name) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("partyName", name);

        List<Party> resultList = jdbcTemplate.query(SELECT_BY_LOGIN_ID, param,
                new BeanPropertyRowMapper<Party>(Party.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    /**
     * user_id、passwordによる検索
     */
    @Override
    public Party findByNameAndPassword(String name, String password) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("partyName", name);
        param.addValue("partyPass", password);

        List<Party> resultList = jdbcTemplate.query(SELECT_BY_LOGIN_ID_AND_PASS, param,
                new BeanPropertyRowMapper<Party>(Party.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    /**
     * 登録
     */
    @Override
    public void insert(Party party) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("partyName", party.getPartyName());
        param.addValue("partyPass", party.getPartyPass());
        param.addValue("date", party.getPartyDate());
        param.addValue("place", party.getPartyPlace());
        param.addValue("come", party.getCome());

        jdbcTemplate.update(INSERT, param);
    }

	@Override
	public void delete(Integer id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("partyId", id);

        jdbcTemplate.update(DELETE, param);

	}

	@Override
	public void update(Party party) {
		 MapSqlParameterSource param = new MapSqlParameterSource();
	        param.addValue("partyName", party.getPartyName());
	        param.addValue("partyPass", party.getPartyPass());
	        param.addValue("partyDate", party.getPartyDate());
	        param.addValue("partyPlace", party.getPartyPlace());
	        param.addValue("partyCome", party.getCome());
	        param.addValue("partyId", party.getPartyId());


	        jdbcTemplate.update(UPDATE, param);

	}
}