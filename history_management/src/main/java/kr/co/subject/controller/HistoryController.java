package kr.co.subject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.subject.dto.Group;
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
	public String addHistory(@RequestParam int groupViewIdx, @RequestParam String contents_text, Model model, RedirectAttributes redirect, MultipartFile upload_file) throws Exception {
		System.out.println("HistoryController: addHistory()");
		
//		for(MultipartFile multiPartFile : upload_file) {
//			System.out.println(multiPartFile.getOriginalFilename());
//			System.out.println(multiPartFile.getSize());
//		}
		
		int userIdx = userService.getUserMemoryStore().getIDX();
		Group groupInfo = userService.getPartOfAllGroupInfo().get(groupViewIdx);
		int groupIdx = groupInfo.getIDX();
		String groupName = groupInfo.getGROUP_NAME();
		
		historyService.createHistory(groupIdx, userIdx);
		History history = historyService.selectHistory(userIdx);
		
		fileService.addFile(upload_file, String.valueOf(history.getIDX()), upload_file.getOriginalFilename(), Long.toString(upload_file.getSize()), String.valueOf(userIdx), groupName);
		textService.addText(history.getIDX(), contents_text, userIdx);
		
		redirect.addAttribute("groupViewIdx", groupViewIdx);
//		redirect.addAttribute("textInfo", groupViewIdx);
		
		
		return "redirect:/group/myGroup";
	}
}