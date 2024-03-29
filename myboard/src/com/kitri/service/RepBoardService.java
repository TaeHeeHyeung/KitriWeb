package com.kitri.service;

import java.util.List;

import com.kitri.dao.RepBoardDAO;
import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;

public class RepBoardService {
	private RepBoardDAO dao;
	public RepBoardService() {
		dao = new RepBoardDAO();
	}
	public String write(RepBoard repBoard) throws AddException {
		repBoard.setParent_seq(0);
		String result= dao.insert(repBoard);
		return result;
	}
	
	public void reply(RepBoard repBoard) throws AddException {
		if(repBoard.getParent_seq()==0) {
			throw new AddException("부모글번호가 없는 답글입니다.");
		}
		dao.insert(repBoard);
	}
	
	public List<RepBoard> findByRows(int startRow, int endRow){
		return dao.select(startRow, endRow);
	}

	public int getTotalCnt() {
		return dao.selectTotalCnt();
	}

	public RepBoard findBySeq(int board_seq) {
		
		return null;
	}
	
}
