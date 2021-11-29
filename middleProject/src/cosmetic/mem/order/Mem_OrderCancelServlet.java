package cosmetic.mem.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/memOrder/cancel")
public class Mem_OrderCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String orderId = request.getParameter("order_id");
		IMemOrderService service = MemOrderServiceImpl.getInstance();
		
		int cancel = service.cancelOrder(orderId);
		
		String check = "";
		
		if(cancel > 0) {
			check = "ok";
		}else {
			check = "no";
		}
		String json = new Gson().toJson(check);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		out.print(json);
		response.flushBuffer();
		
	}

}
