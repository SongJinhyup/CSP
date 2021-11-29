package cosmetic.adminMain.Aprod;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.adminMain.regist.AdminServiceImpl;
import cosmetic.adminMain.regist.IAdminService;
import cosmetic.vo.LprodVO;
import cosmetic.vo.ProductVO;

@WebServlet("/view/AdminProduct1View")
public class AProduct1ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IAdminService service = AdminServiceImpl.getInstance();
		List<ProductVO> list = service.getAllProd();
		
		List<LprodVO> lprodList = service.getLprod();
		List<LprodVO> lprodAList = service.getAllLprodList();
		
		
		request.setAttribute("prodList", list);
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("lprodAList", lprodAList);
		
		request.getRequestDispatcher("/WEB-INF/view/product/product_m1.jsp").forward(request, response);
		
	}

}
