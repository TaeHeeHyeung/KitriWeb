package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;
import com.kitri.service.RepBoardService;
import com.kitri.util.MoveUrl;

/**
 * Servlet implementation class WriteBoard
 */
@WebServlet("/writeboard")
public class WriteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RepBoardService service;

	public WriteBoard() {
		service = new RepBoardService();
	}

	@Override
	public void init() throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String board_subject = request.getParameter("subject");
		String board_writer = request.getParameter("writer");
		String board_password = request.getParameter("password");
		String board_contents = request.getParameter("contents");

		try {
			RepBoard board= new RepBoard(board_subject, board_writer, board_contents, board_password);
			String result = service.write(board);
			request.setAttribute("result", result);
			System.out.println("WriteBoard setattribute result: "+ result);
			System.out.println("WriteBoard moveforward success");	
		} catch (AddException e) {
			System.out.println("WriteBoard moveforward fail");
			e.printStackTrace();
		}
		String path = "/writeresult.jsp";
		MoveUrl.forward(response, request, path);
		
	}
}
