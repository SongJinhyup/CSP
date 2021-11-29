package cosmetic.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.DetailOrderVO;

@WebServlet("/cart/delete")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String orderId = request.getParameter("order_id");
		String prodId = request.getParameter("prod_id");
		
		DetailOrderVO vo = new DetailOrderVO();
		
		vo.setOrder_id(orderId);
		vo.setProd_id(prodId);
		ICartService service = CartServiceImpl.getInstance();
		service.deleteDetailCart(vo);
		
		response.sendRedirect(request.getContextPath()+"/view/cart");
		
	}
}
