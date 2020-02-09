package rodin.repository.vo;

import java.util.Date;

public class PosterVo {
	private Long posterno;
	private String owner;
	private String savedName;
	private String originName;
	private Date regdate;
	public Long getPosterno() {
		return posterno;
	}
	public void setPosterno(Long posterno) {
		this.posterno = posterno;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "PosterVo [posterno=" + posterno + ", owner=" + owner + ", savedName=" + savedName + ", originName="
				+ originName + ", regdate=" + regdate + "]";
	}
	
	
}
