package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Party;

public interface PartyDao {

	public List<Party> findAll();

	 public Party findByNameAndPassword(String partyName, String password);

	 public List<Party> find(Party party);

	 public Party findByName(String name);


	 public void insert(Party party);

	 public void delete(Integer id);

	 public void update(Party party);
}
