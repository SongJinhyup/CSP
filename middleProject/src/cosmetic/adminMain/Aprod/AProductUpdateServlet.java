package cosmetic.adminMain.Aprod;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.adminMain.regist.AdminServiceImpl;
import cosmetic.adminMain.regist.IAdminService;
import cosmetic.vo.ProductVO;

@WebServlet("/AProductUpdateServlet")
public class AProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prod_id = request.getParameter("prod_id");
		String lprod_id = request.getParameter("lprod_id");
		String prod_name = request.getParameter("prod_name");
		int prod_price = Integer.parseInt(request.getParameter("prod_price"));
		int prod_stock = Integer.parseInt(request.getParameter("prod_stock"));
		
		ProductVO prodVo = new ProductVO();
//		prodVo.setProd_id(prod_id);
//		prodVo.setLprod_id(lprod_id);
//		prodVo.setProd_name(prod_name);
//		prodVo.setProd_price(prod_price);
		prodVo.setProd_stock(prod_stock);
		
//		Gson gson = new Gson();
//		String jsonData = "";
		
//		jsonData = gson.toJson(prod_stock);
		
		IAdminService service = AdminServiceImpl.getInstance();
//		service.updateProd(prodVo);
//		service.updateProdStock(lprod_id);
		/*
		 * response.setCharacterEncoding("utf-8");
		 * response.setContentType("application/json; charset=utf-8");
		 * response.getWriter().print(jsonData);
		 */		
		request.getRequestDispatcher("/WEB-INF/view/product/product_m1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
