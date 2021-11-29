package cosmetic.webmain.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.BoardVO;
import cosmetic.webmain.board.BoardServiceImpl;
import cosmetic.webmain.board.IBoardService;

@WebServlet("/noticeList")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		List<BoardVO> boardList = service.getAllNotice();
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/notice/notice.jsp");

		rd.forward(request, response);
	}


}
