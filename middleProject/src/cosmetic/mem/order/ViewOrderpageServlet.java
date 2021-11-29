package cosmetic.mem.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cosmetic.cart.CartServiceImpl;
import cosmetic.cart.ICartService;
import cosmetic.mem.payment.IPaymentService;
import cosmetic.mem.payment.PaymentServiceImpl;
import cosmetic.vo.DetailOrderVO;
import cosmetic.vo.PayVO;
import cosmetic.vo.ProductVO;
import cosmetic.vo.ShipVO;

@WebServlet("/view/order")
public class ViewOrderpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String orderId = request.getParameter("order_id");
		
		IPaymentService payService = PaymentServiceImpl.getInstance();
		ICartService cartService = CartServiceImpl.getInstance();
		IMemOrderService service = MemOrderServiceImpl.getInstance();
		
		PayVO payInfo = payService.getPayInfo(orderId);
		List<ProductVO> list = cartService.orderProduct(orderId);
		ShipVO vo = service.getDelivery(orderId);		
		List<DetailOrderVO> dlist = service.detailOrder(orderId);
	
		
		request.setAttribute("payInfo", payInfo);
		request.setAttribute("ship", vo);
		request.setAttribute("productList", list);
		request.setAttribute("detailOrder", dlist);
		request.getRequestDispatcher("/WEB-INF/view/order/order.jsp").forward(request, response);

	}
}
