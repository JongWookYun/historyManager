package kr.co.subject.dao;

import org.springframework.stereotype.Repository;

import kr.co.subject.dto.Group;
import kr.co.subject.dto.User;

@Repository
public interface GroupDaoInterface {
	Group fillterWithIdx(int IDX) throws Exception;
	Group fillterWithMaker(String MAKER) throws Exception;
	Group fillterWithMadeDate(String MADE_DATE) throws Exception;
	Group fillterWithGroupName(String GROUP_NAME) throws Exception;
	Group fillterWithJoinCode(String JOIN_CODE) throws Exception;
	
	void createGroup(String MAKER, String GROUP_NAME) throws Exception;
	void insertGroupIdIntoUser(String MAKER, String GROUP_ID) throws Exception;
}