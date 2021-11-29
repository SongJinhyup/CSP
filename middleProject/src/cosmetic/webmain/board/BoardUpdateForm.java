package cosmetic.webmain.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/boardUpdateForm")
public class BoardUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_title = request.getParameter("board_title");
		String prod_id = request.getParameter("prod_id");
		String board_id = request.getParameter("board_id");
		String n = null;
		if (request.getParameter("n") != null) {
			n = request.getParameter("n");
		}
		String board_secrete;
		if (request.getParameter("board_secrete") != null) {
			board_secrete = request.getParameter("board_secrete");
		} else {
			board_secrete = "0";
		}
		String board_content = request.getParameter("board_content");
		String board_index = request.getParameter("board_index");
		
		request.setAttribute("board_title", board_title);
		request.setAttribute("prod_id", prod_id);
		request.setAttribute("board_id", board_id);
		request.setAttribute("board_secrete", board_secrete);
		request.setAttribute("board_content", board_content);
		request.setAttribute("board_index", board_index);
		request.setAttribute("n", n);
		
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/WEB-INF/view/QnA/boardUpdate.jsp").forward(request, response);
	}
}
