package kr.co.subject.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import kr.co.subject.dao.GroupDaoInterface;
import kr.co.subject.dao.UserDaoInterface;
import kr.co.subject.dto.Group;

@Service
@MapperScan("kr.co.subject.dao")
public class GroupService {
	
	@Autowired
	private GroupDaoInterface groupDaoInterface;
	
	@Autowired
	private UserDaoInterface userDaoInterface;
	
	@Autowired
	private UserService userService;
	
	public boolean validationGroupName(String GROUP_NAME) throws Exception{
		Group group = groupDaoInterface.fillterWithGroupName(GROUP_NAME);
		return ObjectUtils.isEmpty(group);
	}
	
	public boolean userLevelCheck() {
		if(userService.getUserMemoryStore().getLEVEL() <= 1) {
			return false;
		}
		
		return true;
	}
	
	public void createNewGroup(String GROUP_NAME) throws Exception{
		int MAKER = userService.getUserMemoryStore().getIDX();
		groupDaoInterface.createGroup(Integer.toString(MAKER),GROUP_NAME);
		int GROUP_IDX = groupDaoInterface.fillterWithGroupName(GROUP_NAME).getIDX();
		
		String GROUP_ID = "";
		
		try {
			GROUP_ID = userDaoInterface.selectByUserIdx(MAKER).getGROUP_ID();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(GROUP_ID == "" || GROUP_ID == null) {
			groupDaoInterface.insertGroupIdIntoUser(Integer.toString(MAKER), Integer.toString(GROUP_IDX));
		} else {
			groupDaoInterface.insertGroupIdIntoUser(Integer.toString(MAKER), GROUP_ID + "," + Integer.toString(GROUP_IDX));
		}
	}
	
	public void createJoinCodeToGroup(String groupIdx, String joinCode) throws Exception {
		groupDaoInterface.createJoinCodeToGroup(groupIdx, joinCode);
	}
}
