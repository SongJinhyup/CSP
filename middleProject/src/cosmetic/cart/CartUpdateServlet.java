package cosmetic.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.DetailOrderVO;

@WebServlet("/cart/update")
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String qty = request.getParameter("del_qty");
		String memId = request.getParameter("mem_id");
//		String memId = "a002";
		String orderId = request.getParameter("order_id");
		String prodId = request.getParameter("prod_id");
		
		ICartService service = CartServiceImpl.getInstance();
		
		DetailOrderVO vo = new DetailOrderVO();
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("del_quanity", qty);
		paraMap.put("mem_id", memId);
		paraMap.put("prod_id", prodId);
		System.out.println(paraMap.get("mem_id"));
		paraMap.put("order_id", orderId);
		
		service.updateQtyCart(paraMap);
		
		
	}

}
