package kr.co.subject.dao;

import org.springframework.stereotype.Repository;

import kr.co.subject.dto.Text;

@Repository
public interface TextDaoInterface {
	void addText(String historyIdx, String contents, String userIdx) throws Exception;
	Text selectAllTextInfo(String historyIdx) throws Exception;
}