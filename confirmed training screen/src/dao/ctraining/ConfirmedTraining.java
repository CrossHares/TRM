package dao.ctraining;

public class ConfirmedTraining {

	int citid;
	int tstatis_id; //fk
	int tt_id; //fk
	String ld_user_email; //fk
	String trf_ids;	
	String ct_start_date; //date	
	String ct_end_date; //date		
	String ct_start_time;		
	String ct_end_time;		
	String ct_location;		
	String ct_nomination_file;
	
	public int getCitid() {
		return citid;
	}
	public void setCitid(int citid) {
		this.citid = citid;
	}
	public int getTstatis_id() {
		return tstatis_id;
	}
	public void setTstatis_id(int tstatis_id) {
		this.tstatis_id = tstatis_id;
	}
	public int getTt_id() {
		return tt_id;
	}
	public void setTt_id(int tt_id) {
		this.tt_id = tt_id;
	}
	public String getLd_user_email() {
		return ld_user_email;
	}
	public void setLd_user_email(String ld_user_email) {
		this.ld_user_email = ld_user_email;
	}
	public String getTrf_ids() {
		return trf_ids;
	}
	public void setTrf_ids(String trf_ids) {
		this.trf_ids = trf_ids;
	}
	public String getCt_start_date() {
		return ct_start_date;
	}
	public void setCt_start_date(String ct_start_date) {
		this.ct_start_date = ct_start_date;
	}
	public String getCt_end_date() {
		return ct_end_date;
	}
	public void setCt_end_date(String ct_end_date) {
		this.ct_end_date = ct_end_date;
	}
	public String getCt_start_time() {
		return ct_start_time;
	}
	public void setCt_start_time(String ct_start_time) {
		this.ct_start_time = ct_start_time;
	}
	public String getCt_end_time() {
		return ct_end_time;
	}
	public void setCt_end_time(String ct_end_time) {
		this.ct_end_time = ct_end_time;
	}
	public String getCt_location() {
		return ct_location;
	}
	public void setCt_location(String ct_location) {
		this.ct_location = ct_location;
	}
	public String getCt_nomination_file() {
		return ct_nomination_file;
	}
	public void setCt_nomination_file(String ct_nomination_file) {
		this.ct_nomination_file = ct_nomination_file;
	}

}
