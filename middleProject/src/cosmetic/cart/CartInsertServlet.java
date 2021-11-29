package cosmetic.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/cart/insert")
public class CartInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = request.getParameter("mem_id");
		
		ICartService service = CartServiceImpl.getInstance();
		
		int check = service.insertCart(memId);
		
		String json = new Gson().toJson(check);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		out.print(json);
		response.flushBuffer();
		
		
	}

}
