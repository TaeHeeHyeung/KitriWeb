package control;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.OrderLine;
import com.kitri.dto.Product;
import com.kitri.exception.NotFoundException;
import com.kitri.service.ProductService;

/**
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	
	public ViewCartServlet() {
		service = new ProductService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ViewCartServlet doGet");
		
		String userAgent = request.getHeader("User-Agent");
		String path="";
		
		HttpSession session = request.getSession();
		Map<Product, Integer> c = (Map)session.getAttribute("cart");
		Map<Product, Integer> rc = new HashMap<>();
		
		if( c != null ){
			Set<Product>keys =  c.keySet();
			for(Product p: keys){
				String no = p.getProd_no();
				try{
					Product p1 = service.findByNo(no);
					int quantity = c.get(p);          
					rc.put(p1, quantity);
					System.out.println("ViewCartServlet: map"+ p1.toString()+" "+quantity);
				}catch(NotFoundException e){ }
			}		
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(rc);
//			System.out.println(jsonStr);
			
			System.out.println(userAgent);
			if(userAgent.contains("Dalvik")) {
				request.setAttribute("jsonStr", jsonStr);
				path = "/viewcartresultjson.jsp";
			}else {
				//path = "/viewcartresult.jsp";
				request.setAttribute("rcart", rc);
				path = "/viewcartresult.jsp";
				
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
