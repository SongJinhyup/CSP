package cosmetic.adminMain.Aprod;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.adminMain.regist.AdminServiceImpl;
import cosmetic.adminMain.regist.IAdminService;
import cosmetic.vo.LprodVO;
import cosmetic.vo.ProductVO;

@WebServlet("/view/AdminProductStockUpdate")
public class AProductStockUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String prod_id = request.getParameter("prod_id");
		int prod_stock = Integer.parseInt(request.getParameter("prod_stock"));
		
		ProductVO productVo = new ProductVO();
		productVo.setProd_id(prod_id);
		productVo.setProd_stock(prod_stock);
		
		IAdminService service = AdminServiceImpl.getInstance();
		int i = service.updateProdStock(productVo);
		
		System.out.println("업데이트 성공인가요?" + i);
	
//		response.sendRedirect(request.getContextPath() + "/AdminProduct1View.jsp"); 
//		response.sendRedirect(request.getContextPath() + "/view/AdminProduct1View"); 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
