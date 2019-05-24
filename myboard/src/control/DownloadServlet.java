package control;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("filename");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String gurupath = "c:\\my\\";
		response.setContentType("application/octet-stream");
		//서유럽국가에서 지정한 공식 기본 인코딩이 ISO-8859-1 이기 때문에 기본인코딩을  ISO-8859-1 을 지정해줘야한다.
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ new String(fileName.getBytes("UTF-8"),"ISO-8859-1") + "\"");
 
		FileInputStream fileInputStream = new FileInputStream(gurupath
				+ fileName);
		
 
		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}

}
