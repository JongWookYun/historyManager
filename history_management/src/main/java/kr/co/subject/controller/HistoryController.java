package kr.co.subject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.subject.dto.History;
import kr.co.subject.service.FileService;
import kr.co.subject.service.HistoryService;
import kr.co.subject.service.TextService;
import kr.co.subject.service.UserService;

@Controller
public class HistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private TextService textService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/history/AddHistory")
	public String addHistory(@RequestParam int groupViewIdx, @RequestParam String contents_text, Model model, RedirectAttributes redirect) throws Exception {
		System.out.println("HistoryController: addHistory()");
		
		int userIdx = userService.getUserMemoryStore().getIDX();
		int groupIdx = userService.getPartOfAllGroupInfo().get(groupViewIdx).getIDX();
		
		historyService.createHistory(groupIdx, userIdx);
		History history = historyService.selectHistory(userIdx);
		
		textService.addText(history.getIDX(), contents_text, userIdx);
		
		redirect.addAttribute("groupViewIdx", groupViewIdx);
		return "redirect:/group/myGroup";
	}
}