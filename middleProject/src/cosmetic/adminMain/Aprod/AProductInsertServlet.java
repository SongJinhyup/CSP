package cosmetic.adminMain.Aprod;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.adminMain.regist.AdminServiceImpl;
import cosmetic.adminMain.regist.IAdminService;
import cosmetic.vo.ProductVO;

@WebServlet("/view/AdminProductInsert")
public class AProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String prod_id = request.getParameter("prod_id");
		String lprod_id = request.getParameter("lprod_id");
		String prod_name = request.getParameter("prod_name");
		int prod_price = Integer.parseInt(request.getParameter("prod_price"));
		int prod_stock = Integer.parseInt(request.getParameter("prod_stock"));
		
		ProductVO prodVo = new ProductVO();
		prodVo.setProd_id(prod_id);
		prodVo.setLprod_id(lprod_id);
		prodVo.setProd_name(prod_name);
		prodVo.setProd_price(prod_price);
		prodVo.setProd_stock(prod_stock);

		IAdminService service = AdminServiceImpl.getInstance();
		service.insertProd(prodVo);
		
		response.sendRedirect(request.getContextPath() + "어디로 이동할까여 다시처음으로 돌아갔");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
