package kr.co.subject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.subject.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	
	@PostMapping("/download/file")
	public @ResponseBody String downloadFile(@RequestParam String fileIdx) throws Exception {
		System.out.println("downloadFile()");
		
		System.out.println("fileIdx: " + fileIdx);
		
		// fileService.download();
		
		
		return "success_to_download";
	}
}