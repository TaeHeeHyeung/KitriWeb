package com.kitri.dao;

import java.sql.*;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class RepBoardDAO {
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
//	public static void main(String[] args) {
//		RepBoardDAO dao = new RepBoardDAO();
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
//		
//	}
	 
}
