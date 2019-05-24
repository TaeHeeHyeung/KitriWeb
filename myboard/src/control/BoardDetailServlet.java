package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dao.RepBoardDAO;
import com.kitri.dto.RepBoard;
import com.kitri.service.RepBoardService;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/boarddetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RepBoardService service;
    public BoardDetailServlet() {
        service= new RepBoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq= request.getParameter("board_seq");
		int board_seq= Integer.parseInt(seq);
		RepBoard board = service.findBySeq(board_seq);

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
