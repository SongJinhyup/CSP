package cosmetic.webmain.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/boardInsertForm")
public class BoardInsertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("memId");
		String prodName = request.getParameter("prodName");
		String n = request.getParameter("n");
		
		request.setAttribute("memId", memId);
		request.setAttribute("prodName", prodName);
		request.setAttribute("n", n);
		
		request.getRequestDispatcher("/WEB-INF/view/QnA/boardInsert.jsp").forward(request, response);
	}


}
