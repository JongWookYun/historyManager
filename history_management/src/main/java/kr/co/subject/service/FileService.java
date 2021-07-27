package kr.co.subject.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.subject.dao.FileDaoInterface;
import kr.co.subject.dto.FileDto;
import kr.co.subject.dto.History;

@Service
@MapperScan("kr.co.subject.dao")
public class FileService {
	
	@Autowired
	private FileDaoInterface fileDaoInterface;
	
	List<FileDto> AllOfFileInfoOfHistory;
	List<FileDto> PartOfFileInfoOfHistory;
	
	public void addFile(MultipartFile upload_file, String historyIdx, String fileName, String filePath, String userIdx, String groupName) throws Exception {
		System.out.println("FileService: addFile()");
		
		if(upload_file == null) {
			fileDaoInterface.addFile(historyIdx, null, null, userIdx);
		} else {
			fileDaoInterface.addFile(historyIdx, fileName, filePath, userIdx);
			saveFile(upload_file, fileName, groupName, historyIdx);
		}
	}
	
	public void saveFile(MultipartFile upload_file, String fileName, String groupName, String historyIdx) {
		String path = System.getProperty("user.dir");
		System.out.println("Working Directory = " + path);
		
		String folderDir = "C:/Users/HOME/Desktop/git_repository/historyManager/history_management/src/main/resources/static";
		String fileDir = "file";
		
		String uploadFolder = folderDir + "/" + fileDir + "/" + groupName + "/" + historyIdx;
		
		File folder = new File(uploadFolder);
		if(!folder.exists()) {
			try {
				folder.mkdir();
				System.out.println("폴더 생성: " + uploadFolder);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		
		File saveFile = new File(uploadFolder, fileName);
		
		try {
			upload_file.transferTo(saveFile);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void setFileInfoOfHistory(List<History> historyInfo) throws Exception {
		System.out.println("FileService: setFileInfoOfHistory()");
		
		AllOfFileInfoOfHistory = new ArrayList<FileDto>();
		PartOfFileInfoOfHistory = new ArrayList<FileDto>(4);
		
		if(historyInfo.size() != 0) {
			for(int i = 0; i < historyInfo.size() ;i++) {
				AllOfFileInfoOfHistory.add(fileDaoInterface.selectAllFileInfo(Integer.toString(historyInfo.get(i).getIDX())));
				if(i < 4) {
					PartOfFileInfoOfHistory.add(AllOfFileInfoOfHistory.get(i));
				} else {
					continue;
				}
			}
			System.out.println("AllfTextInfoOfHistory size: " + AllOfFileInfoOfHistory.size());
			System.out.println("PartOfTextInfoOfHistory size: " + PartOfFileInfoOfHistory.size());
		}
	}
	
//	public 
	
	
	public List<FileDto> getAllFileInfoOfHistory() {
		return AllOfFileInfoOfHistory;
	}
	
	public List<FileDto> getPartOfFileInfoOfHistory() {
		return PartOfFileInfoOfHistory;
	}
}