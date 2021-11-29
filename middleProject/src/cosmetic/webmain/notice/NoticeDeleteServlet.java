package cosmetic.webmain.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.webmain.board.BoardServiceImpl;
import cosmetic.webmain.board.IBoardService;


@WebServlet("/noticeDelete")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String boardId = request.getParameter("boardId");
		
		
		System.out.println("지워야 하는 보드 아이디를 받아옵니다" +boardId);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		service.deleteNotice(boardId);
		
	}
}
