package kr.co.subject.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.subject.dao.TextDaoInterface;
import kr.co.subject.dto.Group;
import kr.co.subject.dto.History;
import kr.co.subject.dto.Text;

@Service
@MapperScan("kr.co.subject.dao")
public class TextService {
	
	@Autowired
	private TextDaoInterface textDaoInterface;
	
	List<Text> AllfTextInfoOfHistory;
	List<Text> PartOfTextInfoOfHistory;
	
	public void setTextInfoOfHistory(List<History> historyInfo) throws Exception {
		System.out.println("TextService: setTextInfoOfHistory()");
		
		AllfTextInfoOfHistory = new ArrayList<Text>();
		PartOfTextInfoOfHistory = new ArrayList<Text>(4);
		System.out.println("historyInfo's size: " + historyInfo.size());
		
		
		if(historyInfo.size() != 0) {
			for(int i = 0; i < historyInfo.size() ;i++) {
				AllfTextInfoOfHistory.add(textDaoInterface.selectAllTextInfo(Integer.toString(historyInfo.get(i).getIDX())));
				if(i < 4) {
					PartOfTextInfoOfHistory.add(AllfTextInfoOfHistory.get(i));
				} else {
					continue;
				}
			}
			System.out.println("AllfTextInfoOfHistory size: " + AllfTextInfoOfHistory.size());
			System.out.println("PartOfTextInfoOfHistory size: " + PartOfTextInfoOfHistory.size());
		}
	}
	
	public List<Text> getAllfTextInfoOfHistory() {
		return AllfTextInfoOfHistory;
	}
	
	public List<Text> getPartOfTextInfoOfHistory() {
		return PartOfTextInfoOfHistory;
	}
	
	
	public void addText(int historyIdx, String contents, int userIdx) throws Exception {
		System.out.println("TextService: addText()");
		textDaoInterface.addText(Integer.toString(historyIdx), contents, Integer.toString(userIdx));
	}
	
	
}