package cosmetic.mem.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.ShipVO;

@WebServlet("/Mem_OrderShipservlet")
public class Mem_OrderShipservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String orderId = request.getParameter("order_id");
		
		IMemOrderService service = MemOrderServiceImpl.getInstance();
		ShipVO vo = service.getDelivery(orderId);		
		String json = new Gson().toJson(vo);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		out.print(json);
		response.flushBuffer();
		
	}

}
