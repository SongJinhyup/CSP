package cosmetic.adminMain.regist.blacklist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.adminMain.regist.AdminServiceImpl;
import cosmetic.adminMain.regist.IAdminService;

@WebServlet("/view/AdminBlackListDelete")
public class ABlacklistDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String mem_id = request.getParameter("mem_id");

		IAdminService service = AdminServiceImpl.getInstance();
		service.deleteBlackList(mem_id);

		
		// 목록으로 이동
		response.sendRedirect(request.getContextPath() + "/view/AdminViewMmeber");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
