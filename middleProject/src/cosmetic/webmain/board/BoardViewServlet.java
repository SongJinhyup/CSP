package cosmetic.webmain.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.BoardVO;

@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_id = request.getParameter("board_id");
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		BoardVO view= service.getBoard(board_id);
		
		String json = new Gson().toJson(view);
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(json);
		
		response.flushBuffer();
		
	}
}
