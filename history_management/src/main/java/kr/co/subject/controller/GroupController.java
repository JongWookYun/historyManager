package kr.co.subject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.subject.service.GroupService;
import kr.co.subject.service.UserService;

@Controller
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@PostMapping("/validateGroupName")
	public @ResponseBody String validateGroupName(@RequestParam String gName) throws Exception {
		
		System.out.println("validateGroupName()");

		if(groupService.validationGroupName(gName)) {
			groupService.createNewGroup(gName);
			return "success";
		} else {
			return "fail";
		}
	}
}
