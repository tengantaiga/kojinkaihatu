package jp.co.example.entity;

import java.sql.Date;

import jp.co.example.util.ParamUtil;

public class Party {
	private Integer partyId;
    private String partyName;
    private String partyPass;
    private Date partyDate;
    private String partyPlace;
    private String come;

//    public Party(Integer partyId, String partyName, String partyPass, String Date, String partyPlace, String come) {
//		super();
//
//	}

    public Party() {

    }

    public boolean isEmptyCondition() {
        return partyId == null && ParamUtil.isNullOrEmpty(partyName) ;
    }


    public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public Party(Integer partyId, String partyName, String partyPass, Date partyDate, String partyPlace, String come) {

		this.partyId = partyId;
		this.partyName = partyName;
		this.partyPass = partyPass;
		this.partyDate = partyDate;
		this.partyPlace = partyPlace;
		this.come = come;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyPass() {
		return partyPass;
	}

	public void setPartyPass(String partyPass) {
		this.partyPass = partyPass;
	}

	public Date getPartyDate() {
		return partyDate;
	}

	public void setPartyDate(Date partyDate) {
		this.partyDate = partyDate;
	}

	public String getPartyPlace() {
		return partyPlace;
	}

	public void setPartyPlace(String partyPlace) {
		this.partyPlace = partyPlace;
	}

	public String getCome() {
		return come;
	}

	public void setCome(String come) {
		this.come = come;
	}

//	public String getPartyName() {
//		return partyName;
//	}
//	public void setPartyName(String partyName) {
//		this.partyName = partyName;
//	}
//	public String getPartyPass() {
//		return partyPass;
//	}
//	public void setPartyPass(String partyPass) {
//		this.partyPass = partyPass;
//	}
//	public String getPartyDate() {
//		return Date;
//	}
//	public void setPartyDate(String partyDate) {
//		this.Date = partyDate;
//	}
//	public String getPartyPlace() {
//		return partyPlace;
//	}
//	public void setPartyPlace(String partyPlace) {
//		this.partyPlace = partyPlace;
//	}
//	public String getCome() {
//		return come;
//	}
//	public void setCome(String come) {
//		this.come = come;
//	}


}
