package control;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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
		HttpSession session = request.getSession();
		Map<Product, Integer> c = (Map)session.getAttribute("cart");
		Map<Product, Integer> rc = new HashMap<>();
		System.out.println("ViewCart :cart");
		if( c != null ){
			Set<Product>keys =  c.keySet();
			for(Product p: keys){
				String no = p.getProd_no();
				System.out.println("ViewCart :for");		
				try{
					Product p1 = service.findByNo(no);
					int quantity = c.get(p);          
					rc.put(p1, quantity);
					System.out.println("ViewCart :doget");
				}catch(NotFoundException e){ }
			}
			System.out.println("ViewCart :end for");
			request.setAttribute("rcart", rc);
			String path = "/viewcartresult.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}

	}
}
