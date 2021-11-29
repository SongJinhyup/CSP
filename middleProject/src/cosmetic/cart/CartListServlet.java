package cosmetic.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.DetailOrderVO;

@WebServlet("/cart/List")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = request.getParameter("mem_id");
		
		ICartService service = CartServiceImpl.getInstance();
		
		List<DetailOrderVO> list = service.getCartList(memId);
		
		
		
		
	}

}
