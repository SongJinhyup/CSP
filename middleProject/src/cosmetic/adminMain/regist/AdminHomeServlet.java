package cosmetic.adminMain.regist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.AdminVO;
import cosmetic.vo.BoardVO;
import cosmetic.vo.MemberVO;
import cosmetic.webmain.board.BoardServiceImpl;
import cosmetic.webmain.board.IBoardService;

@WebServlet("/view/AdminHomeMain")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  request.getRequestDispatcher("/WEB-INF/view/main_dark/main_dark.jsp").forward(request,response);
		  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
