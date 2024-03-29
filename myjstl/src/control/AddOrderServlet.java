package control;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.*;
import com.kitri.exception.AddException;
import com.kitri.service.OrderService;
import com.kitri.util.MoveUrl;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private OrderService service;
	public AddOrderServlet() {
		service = new OrderService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddOrder doGet");
		//장바구니 정보 주문테이블에 저장
		OrderInfo info = new OrderInfo();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginInfo");
		Customer c= new Customer(); 
		c.setId(id);
		info.setCustomer(c);//주문자 ID설정
		
		Map<Product,Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
		List<OrderLine> lines = new ArrayList<OrderLine>();
		for(Product p: cart.keySet()) {
			String no = p.getProd_no();
			int quantity = (Integer)cart.get(p);
			
			OrderLine line = new OrderLine(p,quantity);
			lines.add(line);
		}
		info.setLines(lines);
		
		String result ="";
		try {
			service.addOrder(info);
			session.removeAttribute("cart");//장바구니 비우기
			result="1";
		} catch (AddException e) {
			e.printStackTrace();
			result="-1";
		}
		System.out.println("Addordersevlet: "+result);

		request.setAttribute("result", result);
		String path ="/addorderresult.jsp";
		MoveUrl.forward(response, request, path);
		
	}//end doGet



}
