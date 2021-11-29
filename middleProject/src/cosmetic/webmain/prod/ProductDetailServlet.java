package cosmetic.webmain.prod;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.adminMain.regist.AdminServiceImpl;
import cosmetic.adminMain.regist.IAdminService;
import cosmetic.vo.ProductVO;

@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String prod_id = request.getParameter("prod_id");
		
		IAdminService service = AdminServiceImpl.getInstance();

		List<ProductVO> prodList = service.selectProd(prod_id);
		
		request.setAttribute("prodList", prodList);
		
		request.getRequestDispatcher("")
		.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
