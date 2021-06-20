package kr.co.subject.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.subject.dao.UserDaoInterface;
import kr.co.subject.dto.Group;
import kr.co.subject.dto.History;
import kr.co.subject.dto.Text;
import kr.co.subject.dto.User;
import kr.co.subject.service.GroupService;
import kr.co.subject.service.HistoryService;
import kr.co.subject.service.TextService;
import kr.co.subject.service.UserService;

@Controller
public class ViewController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private TextService textService;
	
	@Autowired
	SqlSession session;
	
	@GetMapping("/login")
	public String showLoginPage() {
		System.out.println("viewController: showLoginPage()");
		
		return "/login";
	}
	
	@GetMapping("/user/newAccount")
	public String showNewAccountPage() {
		System.out.println("viewController: showNewAccountPage()");
		
		return "/user/newAccount";
	}
	
	@GetMapping("/main")
	public String showMainPage() {
		System.out.println("viewController: showMainPage()");
		
//		model.addAttribute("groupNames", groupNames);
		return "/main";
	}

	@GetMapping("/group/myGroup")
	public String showPartGroupPage(@RequestParam int groupViewIdx, Model model) throws Exception {
		System.out.println("viewController: showPartGroupPage()");
		
		Group ClickedGroupInfo = userService.getPartOfAllGroupInfo().get(groupViewIdx);
		User WhoMadeThisGroup = userService.selectByUserIdx(ClickedGroupInfo.getMAKER());
		
		historyService.setAllHistoryInfoOfOneGroup(ClickedGroupInfo.getIDX(), session);
		List<History> HistoryInfoOfThisGroup = historyService.getPartOfHistoryInfoOfOneGroup();
		textService.setTextInfoOfHistory(HistoryInfoOfThisGroup);
		List<Text> TextInfoOfThisHistory = textService.getPartOfTextInfoOfHistory();
		
		
		model.addAttribute("groupInfo", ClickedGroupInfo);
		model.addAttribute("userInfo", WhoMadeThisGroup);
		model.addAttribute("textInfo", TextInfoOfThisHistory);
		
		return "/group/myGroup";
	}
	
	@GetMapping("/history/AddHistory")
	public String showAddHistory(@RequestParam int groupViewIdx, Model model) throws Exception {
		System.out.println("viewController: /history/AddHistory()");
		
		model.addAttribute("groupViewIdx", groupViewIdx);
		return "/history/AddHistory";
	}
}