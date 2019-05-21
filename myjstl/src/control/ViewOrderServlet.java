package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.OrderInfo;
import com.kitri.dto.OrderLine;
import com.kitri.service.OrderService;
import com.kitri.util.MoveUrl;

/**
 * Servlet implementation class ViewOrderServlet
 */
@WebServlet("/vieworder")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderService service;
 
    public ViewOrderServlet() {
		this.service = new OrderService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String id = (String) session.getAttribute("loginInfo");

		List<OrderInfo> orderList = service.findById(id);
		
		for(OrderInfo info:orderList) {
			System.out.println("주문번호"+info.getOrder_no()); //주문번호
			System.out.println("주문일자"+info.getOrder_dt());//주문일자
			List<OrderLine> lines = info.getLines();
			for(OrderLine line:lines) {
				System.out.println("상품번호"+line.getProduct().getProd_no());
				System.out.println("상품이름"+line.getProduct().getProd_name());
				System.out.println("상품가격"+line.getProduct().getProd_price());
				System.out.println("상품수량"+line.getOrder_quantity());
			}
		}
		
		String path = "/vieworderresult.jsp";
		request.setAttribute("orderlist", orderList);


		MoveUrl.forward(response, request, path);
	}

}
