package cosmetic.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cosmetic.GetSessionId;
import cosmetic.adminMain.Aprod.AProductUpdateServlet;
import cosmetic.vo.DetailOrderVO;
import cosmetic.vo.MemberVO;
import cosmetic.vo.OrderVO;
import cosmetic.vo.ProductVO;

@WebServlet("/view/cart")
public class ViewCartPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = GetSessionId.getSessionId(request);
//		String memId = "a002";
		
		
		ICartService service = CartServiceImpl.getInstance();
		List<DetailOrderVO> list = service.getCartList(memId);
		if(list == null) {
			list = new ArrayList<DetailOrderVO>();
		}

		ProductVO vo = new ProductVO();
		
		List<ProductVO> plist = service.getCartProdInfo(memId);
		if(plist == null) {
			plist = new ArrayList<ProductVO>();
		}
		
		 OrderVO orderVo = service.getTotalCart(memId);
		
		if(orderVo == null) {
			orderVo = new OrderVO();
			orderVo.setTotal_price(0);
		}
		
		List<MemberVO> mlist = service.getCupon(memId);

		request.setAttribute("orderList", list);
		request.setAttribute("prodList", plist);
		request.setAttribute("oderVO", orderVo);
		request.setAttribute("cupon", mlist);
		request.getRequestDispatcher("/WEB-INF/view/cart/cart.jsp").forward(request, response);
	}

}
