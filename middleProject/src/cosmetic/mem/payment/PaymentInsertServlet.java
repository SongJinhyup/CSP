package cosmetic.mem.payment;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.GetSessionId;
import cosmetic.cart.CartServiceImpl;
import cosmetic.cart.ICartService;
import cosmetic.vo.PayVO;
import cosmetic.vo.ShipVO;

@WebServlet("/payment/insert")
public class PaymentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String orderId = request.getParameter("order_id");
		String payType = "P1";
		int payPrice = Integer.parseInt(request.getParameter("total_price"));
		String address = request.getParameter("address");
		String memId = GetSessionId.getSessionId(request);
		String cupon = request.getParameter("cupon");
		
		IPaymentService service = PaymentServiceImpl.getInstance();
		
		PayVO vo = new PayVO();
		vo.setOrder_id(orderId);
		vo.setPay_type(payType);
		vo.setPay_price(payPrice);
		
		ShipVO shipVo = new ShipVO();
		shipVo.setOrder_id(orderId);
		shipVo.setDel_addr(address);
		
		Random random = new Random();
		int no = random.nextInt(9999999)+1;
		
		String delNo = Integer.toString(no);
		shipVo.setDel_no(delNo);
		shipVo.setMem_id(memId);
		
		
		service.insertPayment(vo);
		
		service.insertDelivery(shipVo);
		ICartService cartService = CartServiceImpl.getInstance();
		
		if(cupon.length() > 16 || cupon != null) {
			cartService.updateCupon(memId);
		}
		
	}
}
