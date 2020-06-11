package jp.co.example.entity;

public class Join {

	private Integer joinId;
	private String loginId;
	private String partyName;
	private String userName;



	public Join() {
		super();


	}
	public Join(Integer joinId, String loginId, String partyName, String userName) {
		super();
		this.joinId = joinId;
		this.loginId = loginId;
		this.partyName = partyName;
		this.userName = userName;
	}

	public Integer getJoinId() {
		return joinId;
	}
	public void setJoinId(Integer joinId) {
		this.joinId = joinId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}



}