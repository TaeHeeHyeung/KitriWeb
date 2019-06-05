package control;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.Product;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("AddCartServlet doGet");
		String no = request.getParameter("no");
		String quantity = request.getParameter("quantity");
//		System.out.println("AddCartServlet no:"+no);
//		System.out.println("AddCartServlet quantity:"+quantity);
		HttpSession session = request.getSession(); //세션이 없으면 자동 생성
		
		Map<Product, Integer> c = (Map)session.getAttribute("cart");
		
		if(c == null) {
			c = new HashMap<>();
			session.setAttribute("cart", c);
		}
//		System.out.println("AddCartServlet sessionId:" +session.getId());
//		System.out.println("AddCartServlet getServletContext:" +session.getServletContext());
		Enumeration<String> enumerHeaderNames = request.getHeaderNames();
		while(enumerHeaderNames.hasMoreElements()) {
			String header = enumerHeaderNames.nextElement();
//			System.out.println("AddCartServlet request.getHeaderName:" + header);
		}
//		System.out.println("cookie: "+request.getHeader("cookie"));
		
		
//		System.out.println("AddCartServlet sessionId:" +session.getSessionContext());
//		System.out.println("AddCartServlet sessionId:" +session.getValueNames().toString());
		
		
		Product p = new Product();
		p.setProd_no(no);
		int intQuantity = Integer.parseInt(quantity);
		
		//장바구니에 해당상품이 존재하는가 확인
		Integer inte = c.get(p);
		if(inte != null) {//존재하면 수량을 합산한다.
			intQuantity += inte.intValue();
		}				
		c.put(p, intQuantity);//장바구니에 상품,수량 추가
		System.out.println(c.get(p));
		String path ="/addcartresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
//		
//		System.out.println("--장바구니 내용--");
//		Set<Product> keys = c.keySet();
//		for(Product key: keys) {
//			int q = c.get(key);
//			System.out.println("상품번호:" + key.getProd_no()+", 수량:" + q);
//		}
	}
}
