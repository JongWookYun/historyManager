package kr.co.subject.dto;

public class FileDto {
	private int IDX;
	private int HISTORY_ID;
	private String FILENAME;
	private String FILEPATH;
	private String UPDATED_TIME;
	private int USER_IDX;
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public int getHISTORY_ID() {
		return HISTORY_ID;
	}
	public void setHISTORY_ID(int hISTORY_ID) {
		HISTORY_ID = hISTORY_ID;
	}
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}
	public String getFILEPATH() {
		return FILEPATH;
	}
	public void setFILEPATH(String fILEPATH) {
		FILEPATH = fILEPATH;
	}
	public String getUPDATED_TIME() {
		return UPDATED_TIME;
	}
	public void setUPDATED_TIME(String uPDATED_TIME) {
		UPDATED_TIME = uPDATED_TIME;
	}
	public int getUSER_IDX() {
		return USER_IDX;
	}
	public void setUSER_IDX(int uSER_IDX) {
		USER_IDX = uSER_IDX;
	}
}