package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class RepBoardDAO {
	
	public List<RepBoard> select(int startRow, int endRow) {
		List<RepBoard> list = new ArrayList<RepBoard>();
		String selectByRowsSQL = "SELECT * "+
		"FROM (SELECT rownum r, repboard.* "+
		"		FROM repboard "+
		"		START WITH parent_seq=0 "+
		"		CONNECT BY PRIOR board_seq = parent_seq "+
		"		ORDER SIBLINGS BY board_seq DESC) "+
		"WHERE r BETWEEN ? AND ?";
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			con= DBConnection.makeConnection();
			pstmt =con.prepareStatement(selectByRowsSQL);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				RepBoard repBoard = new RepBoard();
				repBoard.setBoard_seq(rs.getInt("board_seq"));
				repBoard.setParent_seq(rs.getInt("parent_seq"));
				repBoard.setBoard_subject(rs.getString("board_subject"));
				repBoard.setBoard_writer(rs.getString("board_writer"));
				repBoard.setBoard_contents(rs.getString("board_contents"));
				repBoard.setBoard_date(rs.getTimestamp("board_date"));
				repBoard.setBoard_viewcount(rs.getInt("board_viewcount"));
				list.add(repBoard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
		
	}
	public String insert(RepBoard repBoard) throws AddException{
		String insertSQL = 
	"insert into repboard("
	+"BOARD_SEQ, PARENT_SEQ, BOARD_SUBJECT, BOARD_WRITER,BOARD_CONTENTS,  BOARD_DATE,BOARD_PASSWORD,BOARD_VIEWCOUNT)"
	+" values(BOARD_SEQ.nextval , ?, ?, ?, ?,systimestamp,  ?, 0)";
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			//1)JDBC드라이버로드
			//2)DB연결
			con =DBConnection.makeConnection();

			pstmt = con.prepareStatement(insertSQL);
			pstmt.setInt(1, repBoard.getParent_seq());
			pstmt.setString(2, repBoard.getBoard_subject());
			pstmt.setString(3, repBoard.getBoard_writer());
			pstmt.setString(4, repBoard.getBoard_contents());
			pstmt.setString(5, repBoard.getBoard_password());			
			pstmt.executeUpdate();
			return "1";
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {			
			DBClose.close(con, pstmt);
		}
	}
	
	public int selectTotalCnt() {
		String selectTotalCntSQL = "SELECT count(*) FROM repboard";
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int totalCnt=-1;
		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(selectTotalCntSQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCnt = Integer.parseInt(rs.getString(1));
			}
			return totalCnt;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		return totalCnt;
		
	}
	
	public static void main(String[] args) {
		RepBoardDAO dao = new RepBoardDAO();
//		RepBoard repBoard = new RepBoard();
//		repBoard.setBoard_subject("테스트제목");
//		repBoard.setBoard_writer("test");
//		repBoard.setBoard_contents("테스트내용");
//		repBoard.setBoard_password("testp");
//		repBoard.setParent_seq(1); //답글쓰기용 테스트
//		try {
//			dao.insert(repBoard); //글쓰기용 테스트
//		} catch (AddException e) {
//			e.printStackTrace();
//		}
		List<RepBoard> list= dao.select(11, 50);
		
		for(RepBoard board :list) {
			System.out.println(board.toString());
			
		}
	}//end main
	
	 
}
