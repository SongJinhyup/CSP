package cosmetic.mem.deleteAccount;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.mem.info.IMemberInfoService;
import cosmetic.mem.info.MemberInfoServiceImpl;

@WebServlet("/member/deleteAccount")
public class MemberDeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = request.getParameter("memId");
		IMemberInfoService service = MemberInfoServiceImpl.getInstance();
		int check = service.deleteAccount(memId);
		
		if(check == 1) {
			response.sendRedirect("초기화면 경로.jsp");
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
