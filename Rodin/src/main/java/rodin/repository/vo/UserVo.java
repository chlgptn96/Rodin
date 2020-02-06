package rodin.repository.vo;

import java.util.Date;

public class UserVo {
	
	private Long userno;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String birth;
	private String job;
	private String interests;
	private String profile;
	private Long visit;
	private Date regdate;
	
	public Long getUserno() {
		return userno;
	}
	public void setUserno(Long userno) {
		this.userno = userno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Long getVisit() {
		return visit;
	}
	public void setVisit(Long visit) {
		this.visit = visit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "UserVo [userno=" + userno + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", birth=" + birth + ", job=" + job + ", interests=" + interests + ", profile="
				+ profile + ", visit=" + visit + ", regdate=" + regdate + "]";
	}
	
	
}
