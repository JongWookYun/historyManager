package kr.co.subject.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.subject.dao.HistoryDaoInterface;
import kr.co.subject.dto.History;

@Service
@MapperScan("kr.co.subject.dao")
public class HistoryService {
	
	@Autowired
	private HistoryDaoInterface historyDaoInterface;
	
	List<History> AllHistoryInfoOfOneGroup;
	List<History> PartOfHistoryInfoOfOneGroup;
	
	public void createHistory(int groupDBIdx, int userDBIdx) throws Exception {
		System.out.println("HistoryService: createHistory()");
		
		System.out.println("groupDBIdx: " + groupDBIdx);
		historyDaoInterface.createHistory(Integer.toString(groupDBIdx), Integer.toString(userDBIdx));
	}
	
	public History selectHistory(int userIdx) throws Exception {
		return historyDaoInterface.selectHistory(Integer.toString(userIdx));
	}
	
	public void insertHistoryInfo(int groupIdx, int fileIdx, int textIdx) throws Exception {
		System.out.println(groupIdx);
		historyDaoInterface.insertHistoryInfo(groupIdx, fileIdx, textIdx);
	}
	
	public void setAllHistoryInfoOfOneGroup(int groupIdx, SqlSession session) throws Exception {
		System.out.println("HistoryService: setHistoryInfoOfOneGroup()");
		
		AllHistoryInfoOfOneGroup = new ArrayList<History>();
		PartOfHistoryInfoOfOneGroup = new ArrayList<History>(30);
		
		try {
			AllHistoryInfoOfOneGroup = session.selectList("selectByGroupIdx", Integer.toString(groupIdx));
			for(int i = 0; i < 30; i++) {
				PartOfHistoryInfoOfOneGroup.add(AllHistoryInfoOfOneGroup.get(i));
			}
			System.out.println("AllHistoryInfoOfOneGroup size: " + AllHistoryInfoOfOneGroup.size());
			System.out.println("PartOfHistoryInfoOfOneGroup size: " + PartOfHistoryInfoOfOneGroup.size());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public List<History> getAllHistoryInfoOfOneGroup() {
		return AllHistoryInfoOfOneGroup;
	}
	
	public List<History> getPartOfHistoryInfoOfOneGroup() {
		return PartOfHistoryInfoOfOneGroup;
	}
	
}