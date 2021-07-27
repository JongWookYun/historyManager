package kr.co.subject.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.subject.dto.Group;
import kr.co.subject.service.GroupService;
import kr.co.subject.service.UserService;

@Controller
public class GroupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@PostMapping("/validateGroupName")
	public @ResponseBody String validateGroupName(@RequestParam String gName) throws Exception {
		
		System.out.println("validateGroupName()");

		if(groupService.userLevelCheck()) {
			if(groupService.validationGroupName(gName)) {
				groupService.createNewGroup(gName);
				return "not_exist_group_name";
			} else {
				return "exist_group_name";
			}
		} else {
			return "lack_of_level_privileges";
		}
	}
	
	@PostMapping("/createJoinCodeToGroup")
	public @ResponseBody String createJoinCodeToGroup(@RequestParam String groupViewIdx) throws Exception {
		System.out.println("createJoinCodeToGroup()");
		
		if(userService.getUserMemoryStore().getLEVEL() > 1) {
			List<Group>  groupListInfo = userService.getPartOfAllGroupInfo();
			Group GroupInfo = groupListInfo.get(Integer.parseInt(groupViewIdx));
			
			if(GroupInfo.getJOIN_CODE() == "" || GroupInfo.getJOIN_CODE() == null) {
				// String make
				
				int leftLimit = 48; // numeral '0'
				int rightLimit = 122; // letter 'z'
				int targetStringLength = 8;
				Random random = new Random();

				String joinCode = random.ints(leftLimit,rightLimit + 1)
				  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				  .limit(targetStringLength)
				  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				  .toString();
				
				groupService.createJoinCodeToGroup(String.valueOf(GroupInfo.getIDX()), joinCode);
				return "success_to_create_join_code";
			} else {
				return "exist_join_code";
			}
		} else {
			return "lack_of_level_privileges";
		}
		
		
	}
}
