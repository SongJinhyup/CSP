package cosmetic.webmain.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.BoardVO;

@WebServlet("/review/reviewUpdate")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_id = request.getParameter("board_id");
		
		BoardVO vo = new BoardVO();
		
		vo.setBoard_title(board_title);
		vo.setBoard_content(board_content);
		vo.setBoard_id(board_id);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		service.updateReview(vo);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
