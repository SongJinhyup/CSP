package cosmetic.webmain.prod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cosmetic.GetSessionId;
import cosmetic.cart.CartServiceImpl;
import cosmetic.cart.ICartService;
import cosmetic.vo.LprodVO;
import cosmetic.vo.ProductVO;

/**
 * Servlet implementation class ViewProductServlet
 */
@WebServlet("/view/product")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = GetSessionId.getSessionId(request);
		IProdService service = ProdServiceImpl.getInstance();
		List<ProductVO> list = service.getAllProd();

		
		List<LprodVO> lprodList = service.getLprod();

		ICartService cartService = CartServiceImpl.getInstance();
		
		List<ProductVO> orderList = cartService.getCartProdInfo(memId);
		
		List<LprodVO> totalLprod = service.getAllLprod();

		String orderId = service.countCart(memId);

		request.setAttribute("orderList", orderList);
		request.setAttribute("prodList", list);
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("orderId", orderId);
		request.setAttribute("allLprod", totalLprod);
		request.getRequestDispatcher("/WEB-INF/view/product/product.jsp").forward(request, response);
	}

}
