package kr.co.subject.dto;

public class Group {
	int IDX;
	int MAKER;
	String MADE_DATE;
	String GROUP_NAME;
	String JOIN_CODE;
	int STATUS;
	
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public int getMAKER() {
		return MAKER;
	}
	public void setMAKER(int mAKER) {
		MAKER = mAKER;
	}
	public String getMADE_DATE() {
		return MADE_DATE;
	}
	public void setMADE_DATE(String mADE_DATE) {
		MADE_DATE = mADE_DATE;
	}
	public String getGROUP_NAME() {
		return GROUP_NAME;
	}
	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}
	public String getJOIN_CODE() {
		return JOIN_CODE;
	}
	public void setJOIN_CODE(String jOIN_CODE) {
		JOIN_CODE = jOIN_CODE;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
}
