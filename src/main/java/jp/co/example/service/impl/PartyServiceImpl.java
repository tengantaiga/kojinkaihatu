package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.PartyDao;
import jp.co.example.entity.Party;
import jp.co.example.service.PartyService;

@Service
@Transactional
public class PartyServiceImpl implements PartyService {

	 @Autowired
	    private PartyDao partyDao;


	@Override
	public Party authentication(String partyName, String pass) {
		return partyDao.findByNameAndPassword(partyName, pass);

	}


	@Override
	public List<Party> find(Party party) {
		return partyDao.find(party);
	}



    @Override
    public Party findByName(String name) {
        return partyDao.findByName(name);
    }

    @Override
    public boolean existsPartyByName(String name) {
        return findByName(name) != null;
    }

    /**
     * 登録
     */
    @Override
    public void insert(Party party) {
        partyDao.insert(party);
    }

}
