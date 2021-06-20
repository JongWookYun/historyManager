package kr.co.subject.dto;

public class History {
	int IDX;
	String HISTORY_NAME;
	int GROUP_ID;
	int FILE_ID;
	int TEXT_ID;
	int USER_ID;
	String UPDATED_TIME;
	
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public String getHISTORY_NAME() {
		return HISTORY_NAME;
	}
	public void setHISTORY_NAME(String hISTORY_NAME) {
		HISTORY_NAME = hISTORY_NAME;
	}
	public int getGROUP_ID() {
		return GROUP_ID;
	}
	public void setGROUP_ID(int gROUP_ID) {
		GROUP_ID = gROUP_ID;
	}
	public int getFILE_ID() {
		return FILE_ID;
	}
	public void setFILE_ID(int fILE_ID) {
		FILE_ID = fILE_ID;
	}
	public int getTEXT_ID() {
		return TEXT_ID;
	}
	public void setTEXT_ID(int tEXT_ID) {
		TEXT_ID = tEXT_ID;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUPDATED_TIME() {
		return UPDATED_TIME;
	}
	public void setUPDATED_TIME(String uPDATED_TIME) {
		UPDATED_TIME = uPDATED_TIME;
	}
}