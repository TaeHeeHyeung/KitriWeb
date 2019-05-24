package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.PageBean;
import com.kitri.dto.RepBoard;
import com.kitri.service.RepBoardService;
import com.kitri.util.MoveUrl;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardlist")
public class RepBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RepBoardService service;
	PageBean pageBean;

	public RepBoardListServlet() {
		this.service = new RepBoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("RepBoardListServlet doGet");
		String cp = request.getParameter("currentPage");
//		System.out.println("currentPage: " + cp);
		int currentPage = 1;
		if (cp != null) {
			currentPage = Integer.parseInt(cp);
		}
		
		int cntPerPage = 5;// 페이지별 보여줄 목록수
		int cntPerPageGroup = 3;// 페이지별 보여줄 페이지수

		int totalCnt = service.getTotalCnt();// 총게시글 수
		String url = "boardlist";
	
		pageBean = new PageBean(cntPerPage, totalCnt, cntPerPageGroup, currentPage, url);

		List<RepBoard> list = service.findByRows(pageBean.getStartRow(), pageBean.getEndRow());
		pageBean.setList(list);


		String path = "/listresult.jsp";

		request.setAttribute("pagebean", pageBean);
		MoveUrl.forward(response, request, path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
