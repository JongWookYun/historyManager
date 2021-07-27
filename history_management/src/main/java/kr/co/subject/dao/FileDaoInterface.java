package kr.co.subject.dao;

import org.springframework.stereotype.Repository;

import kr.co.subject.dto.FileDto;

@Repository
public interface FileDaoInterface {
	void addFile(String historyIdx, String fileName, String filePath,String userIdx) throws Exception;
	FileDto selectAllFileInfo(String historyIdx) throws Exception;
}
