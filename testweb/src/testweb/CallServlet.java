package testweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.util.MoveURL;

/**
 * Servlet implementation class CallServlet
 */
@WebServlet("/callservlet")
public class CallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CallServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String data = request.getParameter("data");
		System.out.println(data);
		String path = "new.jsp";
		MoveURL.forward(request, response, path);
	}

}
