package cosmetic.mem.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.OrderVO;

@WebServlet("/memOrder/view")
public class Mem_OrderViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = request.getParameter("mem_id");
		
		IMemOrderService service = MemOrderServiceImpl.getInstance();
		
		List<OrderVO> list = service.orderList(memId);
		
		response.setCharacterEncoding("utf-8");
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		
		out.print(json);
		response.flushBuffer();
	}
}
