package kr.co.subject.dao;

import org.springframework.stereotype.Repository;

import kr.co.subject.dto.History;

@Repository
public interface HistoryDaoInterface {
	History selectHistorybyIdx(String Idx) throws Exception;
	History selectHistorybyGroupId(String groupIdx) throws Exception;
	History selectHistorybyFileId(String FileId) throws Exception;
	History selectHistorybyTextId(String TextId) throws Exception;
	History selectHistorybyUserId(String UserId) throws Exception;
	History selectHistorybyUserUpdatedTime(String UpdatedTime) throws Exception;
	
	History selectHistory(String userIdx) throws Exception;
	void createHistory(String groupDBIdx, String userDBIdx) throws Exception;
	void insertHistoryInfo(int groupIdx, int fileIdx, int textIdx) throws Exception;
}