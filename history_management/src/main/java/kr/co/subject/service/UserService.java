package kr.co.subject.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import kr.co.subject.dao.UserDaoInterface;
import kr.co.subject.dto.Group;
import kr.co.subject.dto.User;

@Service
@MapperScan("kr.co.subject.dao")
public class UserService {
	
	@Autowired
	private UserDaoInterface userDaoInterface;
	
	User UserInfo = new User();
	
	List<Group> AllGroupInfo;
	List<Group> PartOfAllGroupInfo;
	
	public String tryLogin(String userId, String userPw) throws Exception {
		System.out.println("UserService: tryLogin()");
		
		User user = userDaoInterface.checkUserLoginExist(userId, userPw); // 아이디, 비밀번호로 조회 후 user 객체에 담는다.
		
		if(ObjectUtils.isEmpty(user)) {	// user 객체 null 판단
			return "not exist";	// null일 시 회원정보가 없기 때문에 not exist return.
		} else {
			setUserMemoryStore(user);	// null이 아닐 시 해당 회원정보를 어디서든지 참조할 수 있도록 
			setAllGroupInfo(user.getIDX(), user.getGROUP_ID());
			
			return "exist";
		}
	}
	
	public void setUserMemoryStore(User user) {
		UserInfo = user;
	}
	
	public User getUserMemoryStore() {
		return UserInfo;
	}
	
	public void setAllGroupInfo(int userIdx, String groupIdxsOfUser) throws Exception {
		System.out.println("UserService: setAllGroupInfo()");

		AllGroupInfo = new ArrayList<Group>();
		PartOfAllGroupInfo = new ArrayList<Group>(4);
		
		if(groupIdxsOfUser != null) {
			int cnt = 0;
			for(String groupIdxOfUser: groupIdxsOfUser.split(",")) {
				AllGroupInfo.add(userDaoInterface.selectAllGroupInfo(groupIdxOfUser));
				if(cnt < 4) {
					PartOfAllGroupInfo.add(AllGroupInfo.get(cnt));
					cnt++;
				} else {
					continue;
				}
			}
			System.out.println("AllGroupInfo's size: " + AllGroupInfo.size());
			System.out.println("PartOfAllGroupInfo's size: " + PartOfAllGroupInfo.size());
		}
	}
	
	public List<Group> getAllGroupInfo() {
		return AllGroupInfo;
	}
	
	public List<Group> getPartOfAllGroupInfo() {
		return PartOfAllGroupInfo;
	}
	
	public int validationNewAccount(String userId, String userPw, String email, String phone) throws Exception {
		System.out.println("UserService: validationNewAccount()");
		
		int validation_status = 0;
		
		if(userId == "" || userId == null || ! ObjectUtils.isEmpty(selectByUserId(userId))) {
			validation_status = 1;
		}
		if(userPw == "" || userPw == null || ! ObjectUtils.isEmpty(selectByUserPw(userPw))) {
			validation_status = 1;
		}
		if(email == "" || email == null || ! ObjectUtils.isEmpty(selectByUserEmail(email))) {
			validation_status = 1;
		}
		if(phone == "" || phone == null || ! ObjectUtils.isEmpty(selectByUserPhone(phone))) {
			validation_status = 1;
		}
		
		return validation_status;
	}
	
	public void createNewAccount(String userId, String userPw, String email, String phone, String name) throws Exception {
		System.out.println("UserService: createNewAccount()");
		userDaoInterface.createUserNewAccount(userId, userPw, email, phone, name);
	}
	
	public User selectByUserIdx(int userIdx) throws Exception {
		System.out.println("UserService: selectByUserIdx()");
		return userDaoInterface.selectByUserIdx(userIdx);
	}
	
	public User selectByUserId(String userId) throws Exception {
		System.out.println("UserService: selectByUserId()");
		return userDaoInterface.selectByUserId(userId);
	}
	
	public User selectByUserPw(String userPw) throws Exception {
		System.out.println("UserService: selectByUserPw()");
		return userDaoInterface.selectByUserPw(userPw);
	}
	
	public User selectByUserEmail(String userEmail) throws Exception {
		System.out.println("UserService: selectByUserEmail()");
		return userDaoInterface.selectByUserEmail(userEmail);
	}
	
	public User selectByUserPhone(String userPhone) throws Exception {
		System.out.println("UserService: selectByUserPhone()");
		return userDaoInterface.selectByUserPhone(userPhone);
	}
}