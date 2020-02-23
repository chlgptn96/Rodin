package rodin.repository.vo;

import java.util.Date;

public class FontVo {
	private Long fontsno;
	private String fontsName;
	private String fontsCompany;
	private String fontsLicense1;	// 비영리 개인
	private String fontsLicense2;	// 비영리 단체
	private String fontsLicense3;	// 간판, 현수막, 출판물, 웹
	private String fontsLicense4;	// BI, CI
	private String fontsLicense5;	// 임베디드
	private String fontsLicense6;	// 변형
	private String fontsLicense7;	// 재배포
	private Date regdate;
	
	// Custom Font Information
	private double accuracy;
	private String fontPiece;
	
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public String getFontPiece() {
		return fontPiece;
	}
	public void setFontPiece(String fontPiece) {
		this.fontPiece = fontPiece;
	}
	public Long getFontsno() {
		return fontsno;
	}
	public void setFontsno(Long fontsno) {
		this.fontsno = fontsno;
	}
	public String getFontsName() {
		return fontsName;
	}
	public void setFontsName(String fontsName) {
		this.fontsName = fontsName;
	}
	public String getFontsCompany() {
		return fontsCompany;
	}
	public void setFontsCompany(String fontsCompany) {
		this.fontsCompany = fontsCompany;
	}
	public String getFontsLicense1() {
		return fontsLicense1;
	}
	public void setFontsLicense1(String fontsLicense1) {
		this.fontsLicense1 = fontsLicense1;
	}
	public String getFontsLicense2() {
		return fontsLicense2;
	}
	public void setFontsLicense2(String fontsLicense2) {
		this.fontsLicense2 = fontsLicense2;
	}
	public String getFontsLicense3() {
		return fontsLicense3;
	}
	public void setFontsLicense3(String fontsLicense3) {
		this.fontsLicense3 = fontsLicense3;
	}
	public String getFontsLicense4() {
		return fontsLicense4;
	}
	public void setFontsLicense4(String fontsLicense4) {
		this.fontsLicense4 = fontsLicense4;
	}
	public String getFontsLicense5() {
		return fontsLicense5;
	}
	public void setFontsLicense5(String fontsLicense5) {
		this.fontsLicense5 = fontsLicense5;
	}
	public String getFontsLicense6() {
		return fontsLicense6;
	}
	public void setFontsLicense6(String fontsLicense6) {
		this.fontsLicense6 = fontsLicense6;
	}
	public String getFontsLicense7() {
		return fontsLicense7;
	}
	public void setFontsLicense7(String fontsLicense7) {
		this.fontsLicense7 = fontsLicense7;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "FontVo [fontsno=" + fontsno + ", fontsName=" + fontsName + ", fontsCompany=" + fontsCompany
				+ ", fontsLicense1=" + fontsLicense1 + ", fontsLicense2=" + fontsLicense2 + ", fontsLicense3="
				+ fontsLicense3 + ", fontsLicense4=" + fontsLicense4 + ", fontsLicense5=" + fontsLicense5
				+ ", fontsLicense6=" + fontsLicense6 + ", fontsLicense7=" + fontsLicense7 + ", regdate=" + regdate
				+ ", accuracy=" + accuracy + ", fontPiece=" + fontPiece + "]";
	}

}