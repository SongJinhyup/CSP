
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

@WebServlet("/noticeInsert")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String mem_id = request.getParameter("mem_id");
		String board_index = request.getParameter("board_index");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		BoardVO vo = new BoardVO();
		
		vo.setMem_id(mem_id);
		vo.setBoard_index(board_index);
		vo.setBoard_title(board_title);
		vo.setBoard_content(board_content);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int cnt = service.insertNotice(vo);
		
		System.out.println(cnt);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println(" opener.location.reload(); ");
		out.println(" window.close(); ");
		out.println("</script>");
		
		//response.sendRedirect(request.getContextPath() + "/noticeList");

	}

}
