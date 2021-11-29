package cosmetic.mem.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.RefundVO;

@WebServlet("/memOrder/refund")
public class Mem_OrderRefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String orderId = request.getParameter("order_id");
		String prodId = request.getParameter("prod_id");
		
		IMemOrderService service = MemOrderServiceImpl.getInstance();
		
		RefundVO vo = new RefundVO();
		vo.setOrder_id(orderId);
		vo.setProd_id(prodId);
		
		int insert = service.refund(vo);
		
		String check = "";
		
		if(insert == 1) {
			check = "ok";
		}else {
			check = "no";
		}
		Gson gson = new Gson();
		String json = gson.toJson(check);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		out.print(json);
		response.flushBuffer();
	}

}
