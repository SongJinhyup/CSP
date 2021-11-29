package cosmetic.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.DetailOrderVO;

@WebServlet("/cart/insertDetail")
public class CartInsertDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String prodId = request.getParameter("prod_id").trim();
		String orderId = request.getParameter("order_id").trim();
		int price = Integer.parseInt(request.getParameter("del_price").trim());
		
		DetailOrderVO vo = new DetailOrderVO();
		
		vo.setOrder_id(orderId);
		vo.setProd_id(prodId);
		vo.setDel_price(price);
		vo.setDel_quanity(1);
		
		ICartService service = CartServiceImpl.getInstance();
		
		int insert = service.insertDeCart(vo);
		
	}
}
