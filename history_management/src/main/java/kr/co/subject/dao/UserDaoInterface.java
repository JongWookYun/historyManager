package kr.co.subject.dao;

import org.springframework.stereotype.Repository;

import kr.co.subject.dto.Group;
import kr.co.subject.dto.User;

@Repository
public interface UserDaoInterface {
	User checkUserLoginExist(String ID, String PW) throws Exception;
	
	User selectByUserIdx(int userIdx) throws Exception;
	User selectByUserId(String userId) throws Exception;
	User selectByUserPw(String userPw) throws Exception;
	User selectByUserEmail(String userEmail) throws Exception;
	User selectByUserPhone(String userPhone) throws Exception;
	
	void createUserNewAccount(String ID, String PW, String EMAIL, String PHONE, String NAME) throws Exception;
	Group selectAllGroupInfo(String groupIdxOfUser) throws Exception;
}