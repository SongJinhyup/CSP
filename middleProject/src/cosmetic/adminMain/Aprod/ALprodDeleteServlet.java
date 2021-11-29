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

@WebServlet("/view/AdminLprodDelete")
public class ALprodDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String lprod_type = request.getParameter("lprod_type");
		
		IAdminService service = AdminServiceImpl.getInstance();
		service.deleteLprod(lprod_type);
	
		response.sendRedirect(request.getContextPath() + "/view/AdminProduct1View"); 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
