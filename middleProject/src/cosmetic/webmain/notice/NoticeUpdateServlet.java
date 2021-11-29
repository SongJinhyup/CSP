package cosmetic.webmain.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.BoardVO;
import cosmetic.webmain.board.BoardServiceImpl;
import cosmetic.webmain.board.IBoardService;

@WebServlet("/noticeUpdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//보드 아이디 히든으로 들어가야함!~!~!!!!!!
		String board_title = request.getParameter("board_title");
		String board_id = request.getParameter("board_id");
		String board_content = request.getParameter("board_content");
		String boardIndex = request.getParameter("board_index"); 
		
		BoardVO vo = new BoardVO();
		vo.setBoard_title(board_title);
		vo.setBoard_content(board_content);
		vo.setBoard_id(board_id);
		vo.setBoard_index(boardIndex);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int cnt = service.updateNotice(vo);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println(" opener.location.reload(); ");
		out.println(" window.close(); ");
		out.println("</script>");
		//response.sendRedirect(request.getContextPath() + "/noticeList");
	}


}
