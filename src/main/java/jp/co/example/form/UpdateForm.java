package jp.co.example.form;

import java.sql.Date;

public class UpdateForm {

	 private String partyName;
	 private Date partyDate;
	 private String partyPlace;
	 private String partyCome;
     private String confirmPass;
     private String pass;


        public String getPartyName() {
			return partyName;
		}
		public void setPartyName(String partyName) {
			this.partyName = partyName;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
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
		public String getPartyCome() {
			return partyCome;
		}
		public void setPartyCome(String partyCome) {
			this.partyCome = partyCome;
		}
		public String getConfirmPass() {
			return confirmPass;
		}
		public void setConfirmPass(String confirmPass) {
			this.confirmPass = confirmPass;
		}


}
