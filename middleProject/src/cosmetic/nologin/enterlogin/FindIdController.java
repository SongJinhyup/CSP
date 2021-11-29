package cosmetic.nologin.enterlogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModalController
 */
@WebServlet("/findIDControllerServlet")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login/CheckForm.jsp").forward(request, response);
//		request.getRequestDispatcher("login/Iamport.js").forward(request, response);
	}

}
