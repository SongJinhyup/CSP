package cosmetic.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart/insertInterest")
public class CartInterestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("mem_id");
		String prodId = request.getParameter("prod_id");
		
		ICartService service = CartServiceImpl.getInstance();
		
		Map<String,String> paraMap = new HashMap<>();
		
		paraMap.put("mem_id", memId);
		paraMap.put("prod_id", prodId);
		
		int insert = service.insertInterest(paraMap);
	}
}
