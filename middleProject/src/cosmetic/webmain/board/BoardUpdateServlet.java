package cosmetic.webmain.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.BoardVO;

@WebServlet("/board/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//보드 아이디 히든으로 들어가야함!~!~!!!!!!
		String board_title = request.getParameter("board_title");
		String prod_id = request.getParameter("prod_id");
		String board_id = request.getParameter("board_id");
		String board_secrete;
		if (request.getParameter("board_secrete") != null) {
			board_secrete = request.getParameter("board_secrete");
		} else {
			board_secrete = "0";
		}
		String board_content = request.getParameter("board_content");
		String board_index = request.getParameter("board_index");
		
		BoardVO vo = new BoardVO();
		vo.setBoard_title(board_title);
		vo.setProd_id(prod_id);
		vo.setBoard_content(board_content);
		vo.setBoard_secrete(board_secrete);
		vo.setBoard_index(board_index);
		vo.setBoard_id(board_id);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int cnt = service.updateBoard(vo);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println(" opener.location.reload(); ");
		out.println(" window.close(); ");
		out.println("</script>");
	}


}
