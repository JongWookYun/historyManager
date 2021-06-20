package kr.co.subject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.subject.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestParam String ID, String PW, Model model) throws Exception {
		System.out.println("UserController: /login()");
		
		if(userService.tryLogin(ID, PW).equals("exist")) {
			model.addAttribute("PartOfAllGroupInfo", userService.getPartOfAllGroupInfo());
			return "/main";
		} else {
			return "/login";
		}
	}
	
	@PostMapping("/user/newAccount")
	public String newAccount(@RequestParam String ID, String PW, String EMAIL, String PHONE, String NAME) throws Exception {
		System.out.println("UserController: /user/newAccount()");
		
		if(userService.validationNewAccount(ID, PW, EMAIL, PHONE) == 0) {
			userService.createNewAccount(ID, PW, EMAIL, PHONE, NAME);
			return "redirect:/login";
		} else {
			return "/user/newAccount";
		}
	}
}