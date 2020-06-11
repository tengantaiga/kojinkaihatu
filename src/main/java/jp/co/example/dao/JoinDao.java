package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Join;

public interface JoinDao {

	 public void insert(Join join);

	 public List<Join> findByPartyName(String partyName);

	 public List<Join> findByName(String partyName);

}
