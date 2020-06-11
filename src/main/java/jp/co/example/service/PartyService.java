package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Party;

public interface PartyService {

	    public Party authentication(String partyName, String pass);

	    public List<Party> find(Party party);

	    public Party findByName(String partyName);

	    public boolean existsPartyByName(String partyName);

	    public void insert(Party party);



}

